package in.cmss.survey.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.cmss.survey.model.SurveyBuilder;


public interface SurveyRepository extends MongoRepository<SurveyBuilder, Integer> {
 
	public SurveyBuilder findById(String id);
	public Long deleteById(String id);
    
}