package org.link.dexframe.engine;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.link.dexframe.DLEApkParser;
import org.link.dexframe.DLEDexLoader;
import org.link.dexframe.DLEEngine;
import org.link.dexframe.DLEInitiator;
import org.link.dexframe.DLEResource;
import org.link.dexframe.DLP;
import org.link.dexframe.DLPListener;
import org.link.dexframe.log.ConsoleLog;
import org.link.dexframe.log.LogMessage;


import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * 插件框架引擎
 * 如要集成DLE框架，应在工程的AndroidManifest.xml的application节点中的android:name值设置为org.link.dexframe.engine.DexApp
 * @author Link
 * @version 1.0
 */
public class DexApp extends Application implements DLEEngine{
	
	private DLEResource _resourceManager = null;
	
	private DLEApkParser _apkParser = null;
	
	private DLEDexLoader _dexLoader = null;
	
	private DLEEngine _engine = null;
	
	private DLEInitiator _initiator = null;
	
	private DLPListener _dlpListener = null;
	
	private static ClassLoader ORIGINAL_LOADER;
	
	private static ClassLoader CUSTOM_LOADER = null;
	
	private static String c_mBase = "mBase";
	
	private static String c_mPackageInfo = "mPackageInfo";
	
	private static String c_mClassLoader = "mClassLoader";
	
	private static String c_mResources = "mResources";
	
	private static String packageName = "";
	
	private DLP dlp = null;
	
	@Override
	public DLEEngine getInstance() {
		// TODO Auto-generated method stub
		return _engine;
	}

	@Override
	public DLEResource getDLEResource() {
		// TODO Auto-generated method stub
		return _resourceManager;
	}
	
	@Override
	public DLEApkParser getDLEApkParser() {
		// TODO Auto-generated method stub
		return _apkParser;
	}

	@Override
	public DLEDexLoader getDLEDexLoader() {
		// TODO Auto-generated method stub
		return _dexLoader;
	}
	
	@Override
	public DLEInitiator getDLEInitiator() {
		// TODO Auto-generated method stub
		return _initiator;
	}
	
	@Override
	public DLPListener getDLPListener() {
		// TODO Auto-generated method stub
		return _dlpListener;
	}
	
	@Override
	public ClassLoader getORIGINAL_LOADER() {
		return ORIGINAL_LOADER;
	}

	@Override
	public void setORIGINAL_LOADER(ClassLoader oRIGINAL_LOADER) {
		ORIGINAL_LOADER = oRIGINAL_LOADER;
	}

	@Override
	public ClassLoader getCUSTOM_LOADER() {
		return CUSTOM_LOADER;
	}

	@Override
	public void setCUSTOM_LOADER(ClassLoader cUSTOM_LOADER) {
		CUSTOM_LOADER = cUSTOM_LOADER;
	}

	private void init(){
		_apkParser = new ApkInfo();
		_resourceManager = new ResourceManager();
		_dexLoader = new DexLoader();
		_initiator = new Initiator();
		_engine = this;
		_dlpListener = new DLPListenerImpl();
		dlp = new DLP();
		EngineInstance.set(getInstance());
		
	}

	@Override
	protected void attachBaseContext(Context base) {
		// TODO Auto-generated method stub
		super.attachBaseContext(base);
		ConsoleLog.out(LogMessage.FRAME_INIT);
		
		init();
		
		try {
			Context mBase = new ClassFieldGetter<Context>(this, c_mBase).get();

			Object mPackageInfo = new ClassFieldGetter<Object>(mBase, c_mPackageInfo)
					.get();

			ClassFieldGetter<ClassLoader> sClassLoader = new ClassFieldGetter<ClassLoader>(
					mPackageInfo, c_mClassLoader);
			ClassLoader mClassLoader = sClassLoader.get();
			ORIGINAL_LOADER = mClassLoader;

			FrameClassLoader cl = new FrameClassLoader(mClassLoader);
			sClassLoader.set(cl);
		} catch (Exception e) {
			e.printStackTrace();
			ConsoleLog.out(LogMessage.FRAME_INIT_FAILED);
		}
	}


	/**
	 * DexFrame自定义Application层类加载器
	 * @author Link
	 *
	 */
	class FrameClassLoader extends ClassLoader {
		public FrameClassLoader(ClassLoader parent) {
			super(parent);
		}

		@Override
		public Class<?> loadClass(String className)
				throws ClassNotFoundException {
			if (CUSTOM_LOADER != null) {
				try {
					Class<?> c = CUSTOM_LOADER.loadClass(className);
					if (c != null)
						return c;
				} catch (ClassNotFoundException e) {
					ConsoleLog.out(LogMessage.CLASS_NOT_FOUND,className);
				}
			}
			ConsoleLog.out(LogMessage.DEX_EXCEPTION,className);
			return super.loadClass(className);
		}
	}
	
	/**
	 * 类成员变量反射类
	 * @author Link
	 *
	 * @param <T>
	 */
	private class ClassFieldGetter<T> {
		private Object obj;
		private String fieldName;

		private boolean inited;
		private Field field;

		public ClassFieldGetter(Object obj, String fieldName) {
			if (obj == null) {
				throw new IllegalArgumentException("处理对象不能为空");
			}
			this.obj = obj;
			this.fieldName = fieldName;
		}

		private void prepare() {
			if (inited)
				return;
			inited = true;

			Class<?> c = obj.getClass();
			while (c != null) {
				try {
					Field f = c.getDeclaredField(fieldName);
					f.setAccessible(true);
					field = f;
					return;
				} catch (Exception e) {
				} finally {
					c = c.getSuperclass();
				}
			}
		}

		public T get() throws NoSuchFieldException, IllegalAccessException,
				IllegalArgumentException {
			prepare();

			if (field == null)
				throw new NoSuchFieldException();

			try {
				@SuppressWarnings("unchecked")
				T r = (T) field.get(obj);
				return r;
			} catch (ClassCastException e) {
				throw new IllegalArgumentException("无法进行类型转换");
			}
		}

		public void set(T val) throws NoSuchFieldException, IllegalAccessException,
				IllegalArgumentException {
			prepare();

			if (field == null)
				throw new NoSuchFieldException();

			field.set(obj, val);
		}
	}
	
	/**
	 * 资源管理类
	 * @author Link
	 *
	 */
	public class ResourceManager implements DLEResource{
		
		private String m_addAssetPath = "addAssetPath";
		
		private Resources dexRes = null;

		@Override
		public void switchResources(Resources resources){
			// TODO Auto-generated method stub
			ConsoleLog.out(LogMessage.RES_SWITCH);
			try {
				Context mBase 
					= new ClassFieldGetter<Context>(DexApp.this, c_mBase).get();

				Object mPackageInfo 
					= new ClassFieldGetter<Object>(mBase, c_mPackageInfo)
						.get();

				ClassFieldGetter<Resources> sResources 
					= new ClassFieldGetter<Resources>(
						mPackageInfo, c_mResources);
				//Resources mResources = sResources.get();

				sResources.set(resources);
				
			} catch (Exception e) {
				e.printStackTrace();
				ConsoleLog.out(LogMessage.RES_SWITCH_FAILED);
			}
		}


		@Override
		public Resources loadResources(String directory) {
			// TODO Auto-generated method stub
			if(dexRes == null)
				dexRes = DexApp.this.getResources();
			
			AssetManager assets = null;
			try{
				ConsoleLog.out(LogMessage.RES_INIT,directory);
				assets = AssetManager.class.getConstructor(null).newInstance(null);
				Method method = assets.getClass().getMethod(m_addAssetPath,
						new Class[]{String.class});
				Object r = method.invoke(assets, directory);
				
				DisplayMetrics metrics = null;
				Configuration config = null;
				Resources res = new Resources(assets, metrics, config);
				return res;
			}catch(Exception e){
				e.printStackTrace();
				ConsoleLog.out(LogMessage.RES_INIT_FAILED,directory);
			}
			
			return null;
		}


		@Override
		public void restoreResources() {
			// TODO Auto-generated method stub
			if(dexRes == null) return;
			
			switchResources(dexRes);
		}
	}
	
	/**
	 * DLP监听实现
	 * @author Link
	 *
	 */
	public class DLPListenerImpl implements DLPListener {

		@Override
		public void onPluginFinish() {
			// TODO Auto-generated method stub
			_resourceManager.restoreResources();
		}
	}

}