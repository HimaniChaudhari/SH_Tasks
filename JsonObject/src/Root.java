//Pojo Class

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Root {

	@JsonProperty("id")
	private String id;
	@JsonProperty("rules")
    private List<Rules> rules = new ArrayList<Rules>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Rules> getRules() {
		return rules;
	}
	public void setRules(List<Rules> rules) {
		this.rules = rules;
	}
	@Override
	public String toString() {
		return "Root [id=" + id + ", rules=" + rules + "]";
	}
	public Root() {
		super();
	}
	
    
}
