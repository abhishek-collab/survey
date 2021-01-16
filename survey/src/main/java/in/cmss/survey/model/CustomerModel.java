package in.cmss.survey.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter@Setter@ToString
@Document(collection = "Customer")
public class CustomerModel {
	
	@Id    
    private int id;
    private int company_id;
    private String company_name;
    private String company_description;
    private int client_id;
    private String client_name;
    private String client_type;
    private String client_email_id;
    private long client_contact;
    
    private Date client_create_on;
    private Date client_update_on;
   

}
