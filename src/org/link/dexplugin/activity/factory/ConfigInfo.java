package org.link.dexplugin.activity.factory;

import java.util.List;

public class ConfigInfo {
	
	public static List<ActivityInfo> activities = null; 
	
	public static Class<?> getActivityClass(String name){
		
		String activityType = "";
		
		for(ActivityInfo ai : activities){
			if(ai.getName().equals(name)){
				activityType = ai.getType();
				break;
			}
		}
		
		Class clazz = null;
		try {
			clazz = Class.forName(activityType);
			return clazz;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}