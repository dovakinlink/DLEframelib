package org.link.dexframe;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * APK信息解析采集器
 * 解析未安装的APK文件信息
 * @author Link
 * @version 1.0
 */
public interface DLEApkParser {
	
	/**
	 * 加载指定路径的APK包
	 * @param directory
	 * @return
	 */
	public DLEApkParser load(String directory);
	
	/**
	 * 解析已加载的APK文件
	 * @param context
	 */
	public DLEApkParser parsing(Context context);
	
	/**
	 * 获取APK名称
	 * @return
	 */
	public String getName();
	
	/**
	 * 获取APK包名
	 * @return
	 */
	public String getPackageName();
	
	/**
	 * 获取APK图标
	 * @return
	 */
	public Drawable getIcon();
	
	/**
	 * 获取APK版本名称
	 * @return
	 */
	public String getVersionName();
	
	/**
	 * 获取APK版本代码
	 * @return
	 */
	public String getVersionCode();
	
	/**
	 * 获取APK文件路径
	 * @return
	 */
	public String getDirectory();
}