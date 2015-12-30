package org.link.dexplugin.activity.proxy;


import org.link.dexplugin.activity.PluginActivity;
import org.link.dexplugin.activity.factory.ActivityInfo;
import org.link.dexplugin.activity.factory.ConfigInfo;
import org.link.dexplugin.activity.factory.GetActivityInfo;
import org.link.dexplugin.activity.factory.PluginActivityFactory;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
 
public class ProxyActivity extends Activity {
	
	private PluginActivity classInstance = null; 
	
	private String pluginActivityName = null; 
	
	private String getClassName(Activity activity){
		Bundle bundle = activity.getIntent().getExtras();
		String className = null;
		ConfigInfo.activities =
				GetActivityInfo.getInstance(this).parseXml();
		
		if(bundle != null){
			className = bundle.getString("classname");
		} else {
			for(ActivityInfo ai : ConfigInfo.activities){
				if(ai.getIsMain()) {
					className = ai.getName();
					break;
				}
			}
		}
		
		return className;
	}
	

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		super.setContentView(layoutResID);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pluginActivityName = getClassName(this);
		
		if(pluginActivityName != null){
			classInstance = new PluginActivityFactory().orderParams(pluginActivityName,this);
		}
		
		if(classInstance != null)
			classInstance.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		if(classInstance != null)
			classInstance.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		if(classInstance != null)
			classInstance.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		
		if(classInstance != null)
			classInstance.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		if(classInstance != null)
			classInstance.onResume();
	}
}