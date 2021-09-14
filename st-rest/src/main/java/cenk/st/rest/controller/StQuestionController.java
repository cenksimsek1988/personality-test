package cenk.st.rest.controller;

import java.util.List;

import cenk.st.jpa.common.StCategory;
import cenk.st.jpa.entity.*;
import cenk.st.jpa.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cenk.st.jpa.common.StConstants;

@RestController
@CrossOrigin(origins = "${cross.origin}")
@RequestMapping("/question")
public class StQuestionController implements StConstants {

	@Autowired
	private StQuestionRepo qRepo;

	@Autowired
	private StQuestionTypeRepo qTypeRepo;

	@Autowired
	private StConditionalQuestionRepo condQRepo;

	@Autowired
	private StQuestionConditionRepo qCondRepo;

	@Autowired
	private StRangeRepo rangeRepo;

	@Autowired
	private StQuestionPredicateRepo qPredRepo;

	@GetMapping("/byCategory")
	public List<StQuestion> getAnswersByTag(@PathVariable StCategory category) {
		return qRepo.findAllByCategory(category);
	}

	@GetMapping
	public List<StQuestion> getQuestions() {
		return qRepo.findAll();
	}

	@GetMapping(value = "/{id}")
	public StQuestion findById(@PathVariable("id") Long id) {
		return qRepo.findById(id).get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody StQuestion resource) {
		return qRepo.save(resource).getId();
	}

	@PostMapping(value = "/batch")
	@ResponseStatus(HttpStatus.CREATED)
	public Integer createAll(@RequestBody List<StQuestion> resources) {
		for(StQuestion q:resources){
			StQuestionType qType = q.getQuestionType();
			saveQuestionType(qType);

		}
		return qRepo.saveAll(resources).size();
	}

	private void saveQuestionType(StQuestionType qType) {
		StQuestionCondition qCond = qType.getCondition();
		if(qCond!=null){
			qPredRepo.save(qCond.getPredicate());
			StConditionalQuestion ifP = qCond.getIfPositive();
			saveQuestionType(ifP.getQuestionType());
			condQRepo.save(ifP);
			qCondRepo.save(qCond);
		}
		StRange range = qType.getRange();
		if(range!=null){
			rangeRepo.save(range);
		}
		qTypeRepo.save(qType);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable( "id" ) Long id, @RequestBody StQuestion resource) {
		qRepo.save(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		qRepo.deleteById(id);
	}

}
