package org.link.dexframe;

import java.util.List;

import org.link.dexframe.structure.Plugin;

import android.content.Context;

/**
 * 插件启动器
 * @author Link
 *
 */
public interface DLEInitiator {
	
	
	/**
	 * 插件启动器初始化
	 * @param context 上下文环境
	 * @return 插件启动器实例
	 */
	public DLEInitiator init(Context context) throws Exception;
	
	/**
	 * 获取已安装的所有插件信息列表
	 * @return 插件信息列表
	 */
	public List<Plugin> getInstalledPlugin(DLEEngine engine);
		
	
	/**
	 * 启动插件
	 * @param plugin 插件结构体
	 * @param engine DLE引擎
	 */
	public void startPlugin(Plugin plugin, DLEEngine engine);
	
	/**
	 * 加载完成后续处理
	 */
	public void process();
	
	/**
	 * 错误处理
	 */
	public void onFailed();
}