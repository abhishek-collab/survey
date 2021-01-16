package in.cmss.survey.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cmss.survey.model.SurveyBuilder;
import in.cmss.survey.model.UserModel;
import in.cmss.survey.repositories.SurveyRepository;
import in.cmss.survey.repositories.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8888")
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	
	@GetMapping(value = "/questions")
	public Map<String, Object> getAllUsers() {
		
		List<SurveyBuilder> questions =  surveyRepository.findAll();
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("questions", questions);
		responseMap.put("status", 200);
		responseMap.put("message", "Success");
		
		return responseMap;
	}
	
	@GetMapping(value = "/questions/{id}")
	public Map<String, Object> findUser(@PathVariable String id) {
		
		SurveyBuilder questions = surveyRepository.findById(id);
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("question", questions);
		responseMap.put("status", 200);
		responseMap.put("message", "Success");
	    return responseMap;
	}
	
	@PostMapping(value = "/questions")
	public Map<String, Object> saveUser(@RequestBody SurveyBuilder survey) {
		SurveyBuilder savedSurvey = surveyRepository.save(survey);
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("user", savedSurvey);
		responseMap.put("status", 200);
		responseMap.put("message", "Successpring.data.mongodb.database=SurveyBuilders");
	    return responseMap;
	}
	
	@PutMapping(value = "/question")
	public Map<String, Object> updateSurvey(@RequestBody SurveyBuilder survey) {
		SurveyBuilder updatedSurvey = surveyRepository.save(survey);
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("survey", updatedSurvey);
		responseMap.put("status", 200);
		responseMap.put("message", "Success");
	    return responseMap;
	}
	
	@DeleteMapping(value = "/question/{id}")
	public Map<String, Object> deleteSurvey(@PathVariable String id) {
		
		Map<String, Object> responseMap = new HashMap<>();
		
		try {
			surveyRepository.deleteById(id);
			
			responseMap.put("survey", true);
			responseMap.put("status", 200);
			responseMap.put("message", "Success");
			
		} catch (Exception e) {
			responseMap.put("survey", false);
			responseMap.put("status", 500);
			responseMap.put("message", "Error");
		}
		
		
	    return responseMap;
	}

}


