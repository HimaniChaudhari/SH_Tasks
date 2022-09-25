//Pojo Class

import org.codehaus.jackson.annotate.JsonProperty;

public class Condition {

	@JsonProperty("type")
	private String type;
	@JsonProperty("operator")
    private String operator;
	@JsonProperty("value")
    private String value;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Condition [type=" + type + ", operator=" + operator + ", value=" + value + "]";
	}
	public Condition() {
		super();
	}
    
    
}
