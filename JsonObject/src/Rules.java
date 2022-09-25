//Pojo class

import org.codehaus.jackson.annotate.JsonProperty;

public class Rules {
	
	@JsonProperty("fieldName")
	private String fieldName;
	@JsonProperty("fieldType")
    private String fieldType;
	@JsonProperty("condition")
    private Condition condition;
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "Rules [fieldName=" + fieldName + ", fieldType=" + fieldType + ", condition=" + condition + "]";
	}
	public Rules() {
		super();
	}
    
    

}
