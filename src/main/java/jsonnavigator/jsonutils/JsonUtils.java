package jsonnavigator.jsonutils;

import java.util.Arrays;

import com.google.gson.JsonElement;

public class JsonUtils {

	
	public String[] getPathArrayFromString(String path){
		String [] pathString = path.split("\\.");
		
		return pathString;
	}
	
	public JsonElement getElementByPath(String path) {
		String[] pathArray = getPathArrayFromString(path);
		
		for(String entry : pathArray) {
			if(entry.contains("[")) {
				String dirtyArrayIndexString = entry.split("\\[")[1];
				int arrayIndex = Integer.parseInt(dirtyArrayIndexString.substring(0, dirtyArrayIndexString.length() - 1));
				System.out.println(arrayIndex);
			}
		}
		
		return null;
	}
	
	public JsonElement getElementByPath(String path, JsonElement json) {
		String[] pathArray = getPathArrayFromString(path);
		
		for(String entry : pathArray) {
			if(entry.contains("[")) {
				String dirtyArrayIndexString = entry.split("\\[")[1];
				try {
					int arrayIndex = Integer.parseInt(dirtyArrayIndexString.substring(0, dirtyArrayIndexString.length() - 1));
					
				} catch (NumberFormatException e) {
					
				}
			}
		}
		
		return null;
	}
	
	public JsonElement getElement(String[] pathArray, JsonElement json) {
		
		if(json.isJsonArray()) {
			if(pathArray[0].contains("[")) {
				String dirtyArrayIndexString = pathArray[0].split("\\[")[1];
				try {
					int arrayIndex = Integer.parseInt(dirtyArrayIndexString.substring(0, dirtyArrayIndexString.length() - 1));
					if(pathArray.length > 1) {
						return getElement(Arrays.copyOfRange(pathArray, 1, pathArray.length - 1), json.getAsJsonArray().get(arrayIndex));
					}
				} catch (NumberFormatException e) {
					return json.getAsJsonArray();
				}
			}
		} else if(json.isJsonObject()) {
			if(pathArray.length > 0) {
				String key = pathArray[0];
				if(pathArray[0].contains("[")) {
					key = key.split("\\[")[0];
				}
				
				return getElement(Arrays.copyOfRange(pathArray, 1, pathArray.length), json.getAsJsonObject().get(key));
			}
		} else if (json.isJsonPrimitive()) {
			return json;
		}
		
		return null;
	}
}
