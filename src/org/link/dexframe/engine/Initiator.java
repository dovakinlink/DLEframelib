package org.link.dexframe.engine;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.link.dexframe.DLEApkParser;
import org.link.dexframe.DLEEngine;
import org.link.dexframe.DLEInitiator;
import org.link.dexframe.log.ConsoleLog;
import org.link.dexframe.log.LogMessage;
import org.link.dexframe.structure.Plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;


/**
 * 插件启动器
 * 用于启动已存在于/data/data/[package_name]/路径下的插件
 * @author Link
 * @version 1.0
 */
public class Initiator implements DLEInitiator {

	private Context mContext;
	
	private Plugin currentPlugin;
	
	private List<Plugin> installedPlugin;
	
	private String packageName;
	
	/**
	 * 启动加载后的插件，在回调process()中执行
	 */
	private void attachPlugin(){
		Intent intent = new Intent();
		intent.setAction("plugin.activity");
		mContext.startActivity(intent);
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		attachPlugin();
	}

	@Override
	public void onFailed() {
		// TODO Auto-generated method stub
		ConsoleLog.out(LogMessage.PLUGIN_START_FAILED);
		currentPlugin = null;
	}

	@Override
	public DLEInitiator init(Context context) throws Exception {
		// TODO Auto-generated method stub
		mContext = context;
		PackageInfo info = mContext.getPackageManager()
				.getPackageInfo(mContext.getPackageName(), 0);
		packageName = info.packageName;
		return this;
	}
	
	/**
	 * 启动插件
	 * @param plugin 插件信息结构体
	 * @param dexapp 框架引擎实例
	 */
	@Override
	public void startPlugin(Plugin plugin, DLEEngine dexapp){
		ConsoleLog.out(LogMessage.PLUGIN_START,plugin.getName());
		
		if(currentPlugin != null){
			if(currentPlugin.getDirectory().equals(plugin.getDirectory())){
				ConsoleLog.out(LogMessage.PLUGIN_CACHE_EXIST,plugin.getName());
				this.process();
				return;
			}
		}
		currentPlugin = plugin;
		Resources _resources = dexapp.getDLEResource().loadResources(plugin.getDirectory());
		dexapp.getDLEResource().switchResources(_resources);
		
		dexapp.getDLEDexLoader().init(mContext).attachDex(
				plugin.getName(), plugin.getDirectory(), dexapp, this);
	}

	@Override
	public List<Plugin> getInstalledPlugin(DLEEngine engine) {
		// TODO Auto-generated method stub
		List<String> apkList = listAllApk(packageName);
		List<Plugin> installedPlugin = new ArrayList<Plugin>();
		DLEApkParser _apkParser = null;
		_apkParser = engine.getDLEApkParser();
		for(String dir : apkList){
			_apkParser.load(dir).parsing(mContext);
			Plugin plugin = new Plugin();
			
			plugin.setDirectory(_apkParser.getDirectory());
			plugin.setIcon(_apkParser.getIcon());
			plugin.setName(_apkParser.getName() + ".apk");
			plugin.setPackageName(_apkParser.getPackageName());
			plugin.setVersionCode(_apkParser.getVersionCode());
			plugin.setVersionName(_apkParser.getVersionName());
			
			installedPlugin.add(plugin);
		}
		
		return installedPlugin;
	}
	
	@SuppressLint("SdCardPath")
	private static List<String> listAllApk(String packageName){
		List<String> dirList = new ArrayList<String>();
		String dir = "/data/data/" + packageName + "/";
		
		File f = new File(dir);
		FilenameFilter filter = new FilenameFilter() {
			
			@SuppressLint("DefaultLocale")
			@Override
			public boolean accept(File file, String filename) {
				// TODO Auto-generated method stub
				return filename.toLowerCase().endsWith(".apk")? true : false;
			}
		};
		
		String[] apkList = f.list(filter);
		for(String tempName : apkList){
			dirList.add(dir + tempName);
		}
		return dirList;
	}
	
}