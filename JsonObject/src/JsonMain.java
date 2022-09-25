
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonMain {

//	static void getKey(JSONObject json, String keys2) {
//		boolean exists = json.has(keys2);
//		Iterator<?> keys;
//		String nextKeys;
//		
//		if(!exists) {
//			keys = json.keys();
//			while(keys.hasNext()) {
//				nextKeys = (String)keys.next();
//				try {
//					if(json.get(nextKeys) instanceof JSONObject) {
//						
//						if(exists == false) {
//							getKey(json.getJSONObject(nextKeys), keys2);
//						}
//					}else if(json.get(nextKeys) instanceof JSONArray) {
//						JSONArray jsonArray = json.optJSONArray(nextKeys);
//						for(int i=0; i<jsonArray.length(); i++) {
//							String jsonArrayString = jsonArray.get(i).toString();
//							JSONObject innerJson = new JSONObject(jsonArrayString);
//							
//							if(exists == false) {
//								getKey(innerJson, keys2);
//							}
//						}
//					}
//				}catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		}else {
//			parseObject(json,keys2);
//		}
//	}
//	 static void parseObject(JSONObject json, String key) {
//		//System.out.println(json.has(key));
//		System.out.println(json.get(key));
//	}
//	 
	public static void main(String[] args) throws IOException {

		String str1 = "{\"id\":\"1\",\"rules\":[{\"fieldName\":\"age\",\"fieldType\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"gt\",\"value\":\"21\"}},{\"fieldName\":\"rank\",\"fieldType\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"3\"}}]}";
        
		//getKey(strObject,"fieldName");

		ObjectMapper map = new ObjectMapper();
		Root root = map.readValue(str1, Root.class);
		System.out.println(root);
		
		ListIterator<Rules> lir = root.getRules().listIterator();
				while (lir.hasNext()) {
					System.out.println(lir.next());
				}

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of field you want to search: ");
        String search = sc.next();
        
        Map<String, Integer> sParam = new HashMap<>();

       
        int N = sc.nextInt();
        sc.nextLine();

        while (N-- > 0) {

            String fname = sc.next();
            fname =fname.trim();
            int fvalue = sc.nextInt();
            sc.nextLine();
            sParam.put(fname, fvalue);
        }
        System.out.println(sParam);
        
        sParam.forEach((key, value) -> System.out.println(key + " : " + value));
        

        Set<String> s1 = sParam.keySet();
        System.out.println(s1);
        Collection<Integer> s2 = sParam.values();
        System.out.println(s2);
        Set s3 = sParam.entrySet();

        
	}

}
