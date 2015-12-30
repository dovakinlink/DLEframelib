package org.link.dexframe.structure;

import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;

/**
 * 插件信息结构体
 * @author Link
 * @version 1.0
 */
public class Plugin {
	
	 /**
	  * 插件名称
	  */
	 private String name = "";
	 
	 /**
	  * 插件包名
	  */
	 private String packageName = "";
	 
	 /**
	  * 插件图标
	  */
	 private Drawable icon = null;
	 
	 /**
	  * 插件权限列表
	  */
	 private PermissionInfo[] permissions = null;
	 
	 /**
	  * 插件版本号
	  */
	 private String versionName = "";
	 
	 /**
	  * 插件版本码
	  */
	 private String versionCode = "";
	 
	 /**
	  * 插件安装包路径
	  */
	 private String directory = "";

   /**
	* 获取插件名称
	* @return 插件名称
	*/
	public String getName() {
		return name;
	}
	/**
	 * 设置插件名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取插件包名
	 * @return 插件包名
	 */
	public String getPackageName() {
		return packageName;
	}
	/**
	 * 设置插件包名
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	/**
	 * 获取插件图标
	 * @return 插件图标
	 */
	public Drawable getIcon() {
		return icon;
	}
	/**
	 * 设置插件图标
	 */
	public void setIcon(Drawable icon) {
		this.icon = icon;
	}
	/**
	 * 获取插件版本号
	 * @return 插件版本号
	 */
	public String getVersionName() {
		return versionName;
	}
	/**
	 * 设置插件版本号
	 */
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	/**
	 * 获取插件版本码
	 * @return 插件版本码
	 */
	public String getVersionCode() {
		return versionCode;
	}
	/**
	 * 设置插件版本码
	 */
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	/**
	 * 获取插件存放路径
	 * @return 插件存放路径
	 */
	public String getDirectory() {
		return directory;
	}
	/**
	 * 设置插件存放路径
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	/**
	 * 获取插件权限列表
	 */
	public PermissionInfo[] getPermissions() {
		return permissions;
	}
	/**
	 * 设置插件权限列表
	 */
	public void setPermissions(PermissionInfo[] permissions) {
		this.permissions = permissions;
	}
	 
	
}