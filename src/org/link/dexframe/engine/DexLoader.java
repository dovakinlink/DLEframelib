package org.link.dexframe.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.link.dexframe.DLEDexLoader;
import org.link.dexframe.DLEEngine;
import org.link.dexframe.DLEInitiator;
import org.link.dexframe.log.ConsoleLog;
import org.link.dexframe.log.LogMessage;

import dalvik.system.DexClassLoader;
import android.content.Context;
import android.widget.Toast;

/**
 * 插件加载器
 * 用于将插件加载到引擎中。该类方法除特殊功能需求外，不建议直接调用
 * @author Link
 * @version 1.0
 */
public class DexLoader implements DLEDexLoader{
	
	private Context mContext = null;;
	
	@Override
	public DLEDexLoader init(Context context) {
		// TODO Auto-generated method stub
		mContext = context;
		return this;
	}
	
	/**
	 * 加载并优化DEX
	 * @param name      插件名称
	 * @param apkPath   插件apk存放路径
	 * @param dexApp    插件框架引擎实例
	 * @param ns        加载完成后的回调接口对象
	 */
	@Override
	public void attachDex(String name, String apkPath, DLEEngine dexApp,DLEInitiator ns){
		String title = name;
		String path = apkPath;

		try {
			ConsoleLog.out(LogMessage.DEX_ATTACH,apkPath);
			File dex = FileUtil.initApkDirectory(mContext);
			File outdex = FileUtil.initDexDirectory(mContext);
			File dexFile = FileUtil.initAppApk(mContext,dex, path, title);

			if(dexFile != null){
				DexClassLoader dcl = new DexClassLoader(dexFile.getAbsolutePath(),
						outdex.getAbsolutePath(), null,
						dexApp.getORIGINAL_LOADER().getParent());
				dexApp.setCUSTOM_LOADER(dcl);
			}

			ConsoleLog.out(LogMessage.DEX_ATTATCH_SUCCESS,apkPath);
			if(ns != null)
				ns.process();
		} catch (FileNotFoundException e) {
			ConsoleLog.out(LogMessage.DEX_ATTATCH_FAILED,apkPath);
			e.printStackTrace();
			dexApp.setCUSTOM_LOADER(null);
			if(ns != null)
				ns.onFailed();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ConsoleLog.out(LogMessage.DEX_ATTATCH_FAILED,apkPath);
			e.printStackTrace();
			dexApp.setCUSTOM_LOADER(null);
			if(ns != null)
				ns.onFailed();
		} 
	}

}