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

import in.cmss.survey.model.UserModel;
import in.cmss.survey.repositories.UserRepository;





@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:8888")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping(value = "/users")
	public Map<String, Object> getAllUsers() {
		
		List<UserModel> users =  userRepository.findAll();
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("users", users);
		responseMap.put("status", 200);
		responseMap.put("message", "Success");
		
		return responseMap;
	}
	
	@GetMapping(value = "/user/{id}")
	public Map<String, Object> findUser(@PathVariable String id) {
		
		UserModel user = userRepository.findById(id);
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("user", user);
		responseMap.put("status", 200);
		responseMap.put("message", "Success");
	    return responseMap;
	}
	
	@PostMapping(value = "/user")
	public Map<String, Object> saveUser(@RequestBody UserModel user) {
		UserModel savedUser = userRepository.save(user);
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("user", savedUser);
		responseMap.put("status", 200);
		responseMap.put("message", "Successpring.data.mongodb.database=SurveyBuilders");
	    return responseMap;
	}
	
	@PutMapping(value = "/user")
	public Map<String, Object> updateUser(@RequestBody UserModel user) {
		UserModel updatedUser = userRepository.save(user);
		Map<String, Object> responseMap = new HashMap<>();
		
		responseMap.put("user", updatedUser);
		responseMap.put("status", 200);
		responseMap.put("message", "Success");
	    return responseMap;
	}
	
	@DeleteMapping(value = "/user/{id}")
	public Map<String, Object> deleteUser(@PathVariable String id) {
		
		Map<String, Object> responseMap = new HashMap<>();
		
		try {
			userRepository.deleteById(id);
			
			responseMap.put("user", true);
			responseMap.put("status", 200);
			responseMap.put("message", "Success");
			
		} catch (Exception e) {
			responseMap.put("user", false);
			responseMap.put("status", 500);
			responseMap.put("message", "Error");
		}
		
		
	    return responseMap;
	}

}