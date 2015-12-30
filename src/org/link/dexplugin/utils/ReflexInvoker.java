package org.link.dexplugin.utils;

import java.lang.reflect.InvocationTargetException;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

public class ReflexInvoker {
	
	public static void invoke(Context context,String packageName, String className,String method) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, NameNotFoundException{
		Context con;                                      
		con = context
			.createPackageContext(packageName, Context.CONTEXT_INCLUDE_CODE
					|Context.CONTEXT_IGNORE_SECURITY);     // 创建插件句柄	
		
		final Class clazz = con
			.getClassLoader()
			.loadClass(className);
		final Object o=clazz.newInstance();                  // 实例化
		String appName = (String)clazz.getMethod(method).invoke(o); // 获取插件名称
	}
	
	public static void finishPlugin(Context context){
		try {
			invoke(context,"com.example.dledemo","org.link.dexframe.DLP","finish");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}