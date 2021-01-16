package in.cmss.survey.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;



import in.cmss.survey.model.UserModel;

public interface UserRepository extends MongoRepository<UserModel, Integer> {

	public UserModel findById(String id);
	public Long deleteById(String id);
}
