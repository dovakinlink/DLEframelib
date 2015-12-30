package org.link.dexframe.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * APK文件操作工具类
 * 除了一些需要特殊处理的功能需求外，不建议直接调用该类方法
 * @author Link
 * @version 1.0
 */
public class FileUtil {
	
	
	/**
	 * 初始化apk加载时存放目录
	 * [/data/data/[package_name]/app_dex]]
	 * @param context
	 * @return 加载时存放目录路径
	 */
	protected static File initApkDirectory(Context context){
		File dex = context.getDir("dex", Context.MODE_PRIVATE);
		dex.mkdir();
		
		String[] files = dex.list();
		for(String file : files){
			File f = new File(dex.getAbsolutePath() + "/" + file);
			if(f.exists()){
				f.delete();
			}
		}
		return dex;
	}
	
	/**
	 * 初始化dex运行时存放目录
	 * [/data/data/[package_name]/app_outdex]]
	 * @param context
	 * @return 运行时目录路径
	 */
	protected static File initDexDirectory(Context context){
		File fo = context.getDir("outdex", Context.MODE_PRIVATE);
		fo.mkdir();
		
		String[] files = fo.list();
		for(String file : files){
			File f = new File(fo.getAbsolutePath() + "/" + file);
			if(f.exists()){
				f.delete();
			}
		}
		
		return fo;
	}
	
	/**
	 * 将给定apk拷贝到运行时存放目录
	 * [/data/data/[package_name]/app_outdex]]
	 * @param context  上下文
	 * @param dexDir   apk运行时存放目录
	 * @param apkPath  apk源文件存放路径
	 * @param name     apk名称
	 * @return 优化后的插件DEX文件
	 */
	protected static File initAppApk(Context context, File dexDir, String apkPath, String name)
			throws FileNotFoundException , IOException{
		File f = new File(dexDir, name);
		File apk = new File(apkPath);
		
		InputStream fis = new FileInputStream(apk);  
		FileOutputStream fos = new FileOutputStream(f);
		byte[] buffer = new byte[0xFF];
		int len;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		fis.close();
		fos.close();
		
		return f;
	}
	
}