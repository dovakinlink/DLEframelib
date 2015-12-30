package org.link.dexframe;

/**
 * DLE引擎
 * 使用时请将dexframelib引用到工程，并在AndroidManifest中将Application置为：org.link.dexframe.engine.DexApp
 * 如要获取DLE实例，请在代码中添加以下代码： DLEEngine yourParam = (DLEEngine) getApplication();
 * DLE引擎将使你的应用具有以下功能：
 *  1.动态加载启动未安装的APK插件（插件需要在dexpluginlib框架下编写）。加载后的APK拥有完整的Activity生命周期
 *    在更新插件或者安装卸载插件或者启动关闭插件时，主应用不用关闭
 *  2.可定制皮肤包，并可实时的更新全应用的皮肤（皮肤包以APK形式存在，不需要安装）
 *    而且不需要对已有代码进行修改，并不影响现有开发流程
 *  3.引进补丁机制。补丁机制可让你在不“卸载”，不“关闭”，不“重启”应用的前提下，实现应用中某个模块的代码级更新
 *    更新文件以APK形式存在，不需要安装
 * 如需更多 帮助 或 开发样例，请参考 DLE开发帮助文档
 * @author Link
 *
 */
public interface DLEEngine {
	
	/**
	 * 获取DLE引擎
	 * @return
	 */
	public DLEEngine getInstance();
	
	/**
	 * 获取APK信息解析器
	 * @return
	 */
	public DLEApkParser getDLEApkParser();
	
	/**
	 * 获取插件加载器
	 * @return
	 */
	public DLEDexLoader getDLEDexLoader();
	
	/**
	 * 获取插件启动器
	 * @return
	 */
	public DLEInitiator getDLEInitiator();
	
	/**
	 * 获取DLP插件监听器 
	 * @return
	 */
	public DLPListener getDLPListener();
	
	/**
	 * 获得资源管理对象
	 * @return ResourceManager对象
	 */

	public DLEResource getDLEResource();
	
	/**
	 * 获得原（自带）类加载器
	 * @return ORIGINAL_LOADER
	 */
	public ClassLoader getORIGINAL_LOADER();

	/**
	 * 设置原（自带）类加载器
	 * @param ORIGINAL_LOADER
	 */
	public void setORIGINAL_LOADER(ClassLoader ORIGINAL_LOADER);

	/**
	 * 获得当前类加载器
	 * @return CUSTOM_LOADER
	 */
	public ClassLoader getCUSTOM_LOADER();

	/**
	 * 设置当前类加载器
	 * @param CUSTOM_LOADER
	 */
	public void setCUSTOM_LOADER(ClassLoader CUSTOM_LOADER);
}