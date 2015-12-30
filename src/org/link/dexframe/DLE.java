package org.link.dexframe;

import android.app.Application;
import android.content.Context;

/**
 * DLE
 * 使用DLE.init方法来启动DLE，这是每个DLE框架应用首先且必须要做的事
 * @author Link
 * @version 1.0
 */
public class DLE {
	
	private static Boolean isInit = false;
	
	/**
	 * DLE引擎
	 */
	public static DLEEngine engine; 
	
	/**
	 * 插件信息采集器
	 */
	public static DLEApkParser apkParser;
	
	/**
	 * 插件加载器
	 */
	public static DLEDexLoader dexLoader;
	
	/**
	 * 插件启动器
	 */
	public static DLEInitiator initiator;
	
	/**
	 * 运行时资源管理器
	 */
	public static DLEResource resourceManager;
	
	/**
	 * 启动DLE
	 * @param context 上下文环境
	 * @param app 应用的Application，通常通过getApplication()获得
	 */
	public static void init(Context context,Application app){
		
		if(isInit) return;
		
		engine = (DLEEngine) app;
		apkParser = engine.getDLEApkParser();
		dexLoader = engine.getDLEDexLoader();
		initiator = engine.getDLEInitiator();
		resourceManager = engine.getDLEResource();
		
		dexLoader.init(context);
		try {
			initiator.init(context);
			isInit = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isInit = false;
		}
		
	}
}