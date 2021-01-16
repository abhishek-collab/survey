package in.cmss.survey.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import in.cmss.survey.model.CustomerModel;

public interface CustomerRepository extends MongoRepository<CustomerModel, Integer> {

    
}
