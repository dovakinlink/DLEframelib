package org.link.dexframe;

import android.content.Context;

/**
 * 插件加载器
 * @author Link
 * @version 1.0
 */
public interface DLEDexLoader {

	/**
	 * 初始化插件加载器
	 * @param context 上下文环境
	 * @return 插件加载器实例
	 */
	public DLEDexLoader init(Context context);

	/**
	 * 加载插件
	 * 仅仅是加载，并不启动
	 * @param name 插件名称
	 * @param directory 插件路径
	 * @param engine DLE引擎
	 * @param ns 插件启动器监听接口   
	 * 			 -null  不做回调处理
	 */
	public void attachDex(String name, String directory, DLEEngine engine,DLEInitiator ns);

}