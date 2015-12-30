package org.link.dexframe.log;

/**
 * 日志信息
 * @author Link
 * @version 1.0
 */
public class LogMessage {
	
	public static final String FRAME_INIT = "框架初始化...";
	
	public static final String FRAME_INIT_FAILED = "框架初始化失败！请查看logcat日志";
	
	public static final String RES_SWITCH = "正在进行应用Resources资源替换...";
	
	public static final String RES_SWITCH_FAILED = "资源替换失败！可能的原因：resources参数为空";
	
	public static final String CLASS_NOT_FOUND = "DEX类加载器未能找到制定类！";
	
	public static final String DEX_EXCEPTION = "DEX类加载器未能正常初始化或未找到待加载类，正在尝试使用父类类加载器加载 ...";
	
	public static final String RES_INIT = "正在创建资源对象...";
	
	public static final String RES_INIT_FAILED = "创建资源对象失败！可能的原因：请检查文件路径";
	
	public static final String DEX_ATTACH = "正在进行DEX优化...";
	
	public static final String DEX_ATTATCH_SUCCESS = "插件已成功加载";
	
	public static final String DEX_ATTATCH_FAILED = "插件加载失败！请检查文件路径";
	
	public static final String APK_INFO_INIT = "正在进行APK信息采集...";
	
	public static final String APK_INFO_INIT_FAILED_DIR = "APK信息采集失败！路径无效";
	
	public static final String APK_INFO_INIT_FAILED_UNKOWN = "APK信息采集失败！未知原因";
	
	public static final String PLUGIN_START = "正在启动插件...";
	
	public static final String PLUGIN_CACHE_EXIST = "插件已经加载，直接进行启动...";
	
	public static final String PLUGIN_START_FAILED = "启动插件失败！";
	
}