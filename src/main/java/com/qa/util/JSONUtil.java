package com.qa.util;

import com.google.gson.Gson;

//import org.json.simple.JSONValue;

public class JSONUtil {

	private Gson gson;
	
	


	public JSONUtil() {
		this.gson = new Gson();
	}
	
	//GET JSON FROM OBJECT
	//return JSON when given a Java Object
	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
//		return JSONValue.toJSONString(obj);
		
	}

	//GET OBJECT FROM JSON
	//return Object when given a JSON
	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		
		return gson.fromJson(jsonString, clazz);
//		return (T) JSONValue.parse(jsonString);
	}
	
	

}