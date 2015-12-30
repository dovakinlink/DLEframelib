package org.link.dexframe;

import android.content.res.Resources;

/**
 * 系统运行时Resources管理器
 * @author Link
 *
 */
public interface DLEResource {
	
	/**
	 * 加载未安装APK并建立起其对应的Resource对象
	 * @param directory 未安装APK存放路径
	 * @return Resources 资源对象
	 */
	public Resources loadResources(String directory);
	
	/**
	 * 更改当前应用所引用的Resources
	 * 用于插件资源加载以及皮肤包动态部署
	 * @param resources 资源对象
	 */
	public void switchResources(Resources resources);
	
	/**
	 * 恢复当前应用所引用的Resources
	 * @param resources
	 */
	public void restoreResources();
}