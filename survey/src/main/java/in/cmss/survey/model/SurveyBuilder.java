package in.cmss.survey.model;


	
	
	import lombok.Getter;
	import lombok.Setter;
	import lombok.ToString;
	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

	import java.util.Date;
import java.util.List;

	@Getter@Setter@ToString
	@Document(collection = "SurveyQuestion")
	public class SurveyBuilder {
	    @Id    
	    private int id;
	    private int survey_id;
	    private String survey_description;
	    private Date survey_create_on;
	    private Date survey_update_on;
	    private List<Question> questions;
	    
	    private int user_id;
	   


	

}
