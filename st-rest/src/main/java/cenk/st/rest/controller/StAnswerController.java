package cenk.st.rest.controller;

import cenk.st.jpa.common.StConstants;
import cenk.st.jpa.entity.StAnswer;
import cenk.st.jpa.entity.StSession;
import cenk.st.jpa.repo.StAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class StAnswerController implements StConstants {

	@Autowired
	private StAnswerRepo aRepo;

	@GetMapping("/bySession")
	public List<StAnswer> getBySession(@PathVariable StSession session) {
		return aRepo.findAllBySession(session);
	}

	@GetMapping("/byRespondentName")
	public List<StAnswer> getByRespondent(@PathVariable String respondent) {
		return aRepo.findAllBySessionRespondent(respondent);
	}

	@GetMapping
	public List<StAnswer> get() {
		return aRepo.findAll();
	}

	@GetMapping(value = "/{id}")
	public StAnswer findById(@PathVariable("id") Long id) {
		return aRepo.findById(id).get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody StAnswer resource) {
		return aRepo.save(resource).getId();
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable( "id" ) Long id, @RequestBody StAnswer resource) {
		aRepo.save(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		aRepo.deleteById(id);
	}

}
