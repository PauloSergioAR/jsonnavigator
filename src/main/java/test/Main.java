package test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import jsonnavigator.jsonutils.JsonUtils;

public class Main {
	public static void main(String[] args) {
		JsonUtils su = new JsonUtils();
		
		String testPath = "obj1.obj2.obj3[1]";
		
		JsonElement json = JsonParser.parseString(SampleJsons.json1);
		
		JsonElement test = su.getElement(su.getPathArrayFromString(testPath), json);
		
		System.out.println(test);
		
		//System.out.println(splitPath);
	}
}
