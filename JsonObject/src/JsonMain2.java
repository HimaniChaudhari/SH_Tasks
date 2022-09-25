
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonMain2 {

	public static void main(String[] args) throws IOException, SQLException {

		//Converting json object to string to store json object in string format in database.
		String str1 = "{\"id\":\"1\",\"rules\":[{\"fieldName\":\"age\",\"fieldType\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"gt\",\"value\":\"21\"}},{\"fieldName\":\"rank\",\"fieldType\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"3\"}}]}";
        String str2 = "{\"id\":\"2\",\"rules\":[{\"fieldName\":\"age\",\"fieldType\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"lt\",\"value\":\"30\"}},{\"fieldName\":\"rank\",\"fieldType\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"5\"}}]}";
        String str3 = "{\"id\":\"3\",\"rules\":[{\"fieldName\":\"state\",\"fieldType\":\"string\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"Maharashtra\"}},{\"fieldName\":\"city\",\"fieldType\":\"string\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"Pune\"}},{\"fieldName\":\"age\",\"fieldType\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"lt\",\"value\":\"30\"}}]}";
      
        //User input to get what he want to search.
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the field and values you want to search: ");
		String search = sc.next();
        
		//initializing and adding strings to arraylist to store the coverted string in arraylist.
		List<String> strList = new ArrayList();
        strList.add(str1);
        strList.add(str2);
        strList.add(str3);
        
        //initializing linked hash map to store the user input information for further search.
		HashMap<String, Object> searchParam = new LinkedHashMap<>();

        //initializing variable for while loop for iteration.
        int stringListNo=0;
        
        //while loop stated to check parameter in every string in arraylist.
        while (stringListNo < strList.size()) {
        	        
        //to convert the json string to java object form and reading its value in the Root class format.
		ObjectMapper objectmapper = new ObjectMapper();
		Root root = objectmapper.readValue(strList.get(stringListNo), Root.class);
		System.out.println(root);		

			//to store validate method return.
			boolean field;
			//initializing ArrayList to store the boolean value of searchParam.
			List boolList = new ArrayList();
			
			//splitting the user input based on "," and storing it in comArray string array.
			if (search.indexOf(",") > 1) {
			    String[] comArray = search.split(",");
			    //int count = comArray.length;
			    for (String s : comArray) {
			    	//splitting the user input based on "=" and storing it in eqArray string array.
			        String[] eqArray = s.split("=");
			        //storing the key value pair in linkedHashMap.
			        searchParam.put(eqArray[0], eqArray[1]);
			        //System.out.println(searchParam.containsKey(eqArray[0]));
			        //System.out.println(searchParam.containsValue(eqArray[1]));
			        if(eqArray[0]!= null) {
			        	//loop for rules list in json object to search parameter.
			        	for (Rules rule : root.getRules()) {
						    for (String Key : searchParam.keySet()) {
						    	
				        		//for for if the user input key matches with the param present in the java object.
						        if (Key.equals(rule.getFieldName())) {
						            Condition condition = rule.getCondition();
						            //calling validate method to verify the operator in object and returning boolean value and storing it.
						            field= validate(searchParam.get(Key).toString(), rule.getFieldType(), condition);
						            boolList.add(field);					            
						        }
						    }
						}
			        }		      
			    }
			    
			    int i=0;
		        int getid;
		        
		        	//loop while the size of boolList is not 0.
		            while (i < boolList.size()) {
		            	//if boolean 
		                if((boolean) boolList.get(i)) {
		                	getid = Integer.parseInt(root.getId());
		                        if(getid != 0) {
		                            pass(getid);
		                        	//System.out.println(getid);
		                			
		                				break;
		                            
		                			}
		                    } else break;
		                i++;
		            }        
			}
			//scanner closed.
			sc.close();
			stringListNo++;
        }//1st while loop ends
	        
	}	
		
	//Passing id and database connection method.
	static void pass(int i) throws SQLException {
		//Database connect established.
		Connection conn = null;
		//Driver for PostreSql is registered.
		DriverManager.registerDriver(new org.postgresql.Driver());

		  // giving my connection info about db name, username and password.
		  conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Welcome@2022");

		System.out.println("Database connection establised.");
		
		Statement stmt = conn.createStatement();
		//query to run as statement when called.
		String query = "select * from customers where id = ?";

		//to give id at runtime.
		PreparedStatement ps;
		ps=conn.prepareStatement(query);
		ps.setInt(1, i);
		//executing the query and takin the result in resultSet.
    	ResultSet rs =	ps.executeQuery();
		
    	//iteraing resultSet to fetch individual values from database.
		while(rs.next()) {
			
			
			int custid =	rs.getInt("id");
			String custname = rs.getString("name");
			int custage = rs.getInt("age");
			String cusAddress = rs.getString("address");
			double salary = rs.getDouble("salary");
		
			
			System.out.println(custid +"  "+custname +"  "+custage + "  "+cusAddress+ "  "+salary);
		}
		//closing the connection.
		conn.close();
		System.out.println("Databse connection closed.");
	}

	//Validate function for verify operator in java object and returning boolean value.
	private static boolean validate(String search, String fieldType, Condition condition) {

		if(condition.getOperator().equals("gt")) {
			//System.out.println(Integer.parseInt(search) > Integer.parseInt(condition.getValue()));
            return Integer.parseInt(search) > Integer.parseInt(condition.getValue());
        }
        if(condition.getOperator().equals("lt")) {
            return Integer.parseInt(search) < Integer.parseInt(condition.getValue());
        }
        if(condition.getOperator().equals("eq")) {
        	//System.out.println(search.equals(condition.getValue()));
            return search.equals(condition.getValue());
        }
        if(condition.getOperator().equals("gteq")) {
            return Integer.parseInt(search) >= Integer.parseInt(condition.getValue());
        }
        
        return false;
		
	}
	
}
