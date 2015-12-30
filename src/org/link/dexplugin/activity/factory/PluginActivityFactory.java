package org.link.dexplugin.activity.factory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import org.link.dexplugin.activity.PluginActivity;
import org.link.dexplugin.activity.PluginFragmentActivity;
import org.link.dexplugin.activity.proxy.ProxyActivity;
import org.link.dexplugin.activity.proxy.ProxyFragmentActivity;

public class PluginActivityFactory extends Store {
	
	@Override
	protected PluginActivity createParams(String questParam, ProxyActivity pa) {
		// TODO Auto-generated method stub
		
			Class clazz;
			PluginActivity instance = null;
			try {
				clazz = Class.forName(questParam);
				instance = (PluginActivity)clazz.newInstance();
				instance.setActivity(pa);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return instance;
		//return (PluginActivity)ActivityInfo.map.get(questParam);
	}

	@Override
	protected PluginFragmentActivity createParams(String questParam,
			ProxyFragmentActivity pa) {
		// TODO Auto-generated method stub
		Class clazz;
		PluginFragmentActivity instance = null;
		try {
			clazz = Class.forName(questParam);
			instance = (PluginFragmentActivity)clazz.newInstance();
			instance.setActivity(pa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return instance;
	}

}