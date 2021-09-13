package cenk.st.rest.controller;

import java.util.List;

import cenk.st.jpa.common.StCategory;
import cenk.st.jpa.entity.*;
import cenk.st.jpa.repo.StConditionalQuestionRepo;
import cenk.st.jpa.repo.StQuestionPredicateRepo;
import cenk.st.jpa.repo.StQuestionRepo;
import cenk.st.jpa.repo.StQuestionTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cenk.st.jpa.common.StConstants;

@RestController
@RequestMapping("/question")
public class StQuestionController implements StConstants {

	@Autowired
	private StQuestionRepo qRepo;

	@Autowired
	private StQuestionTypeRepo qTypeRepo;

	@Autowired
	private StConditionalQuestionRepo condQRepo;

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
		/*for(StQuestion q:resources){
			StQuestion nq = new StQuestion();
			nq = qRepo.save(nq);
			StQuestionType nQType = new StQuestionType();
			nQType = qTypeRepo.save(nQType);
			nq.setQuestionType(nQType);
			StQuestionType qType = q.getQuestionType();
			StQuestionCondition qCond = qType.getCondition();
			if(qCond!=null){
				StQuestionPredicate qPred = qCond.getPredicate();
				qPred = qPredRepo.save(qPred);
				qCond.setPredicate(qPred);
				StConditionalQuestion condQ = qCond.getIfPositive();
				condQ = condQRepo.save(condQ);
				qCond.setIfPositive(condQ);
			}
		}*/
		return qRepo.saveAll(resources).size();
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
