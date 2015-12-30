package org.link.dexplugin.activity.proxy;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.link.dexplugin.activity.PluginFragmentActivity;
import org.link.dexplugin.activity.factory.ActivityInfo;
import org.link.dexplugin.activity.factory.ConfigInfo;
import org.link.dexplugin.activity.factory.GetActivityInfo;
import org.link.dexplugin.activity.factory.PluginActivityFactory;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
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

@SuppressLint("NewApi")
public class ProxyFragmentActivity extends FragmentActivity{
	private PluginFragmentActivity classInstance = null; 
	
	private String pluginFragmentActivityName;
	
	private String getClassName(Activity activity){
		Bundle bundle = activity.getIntent().getExtras();
		String className = null;
		ConfigInfo.activities =
				GetActivityInfo.getInstance(activity).parseXml();
		
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
	
	@SuppressLint("NewApi")
	@Override
	public void dump(String prefix, FileDescriptor fd, PrintWriter writer,
			String[] args) {
		// TODO Auto-generated method stub
		super.dump(prefix, fd, writer, args);
	}

	@Override
	public Object getLastCustomNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return super.getLastCustomNonConfigurationInstance();
	}

	@Override
	public FragmentManager getSupportFragmentManager() {
		// TODO Auto-generated method stub
		return super.getSupportFragmentManager();
	}

	@Override
	public LoaderManager getSupportLoaderManager() {
		// TODO Auto-generated method stub
		return super.getSupportLoaderManager();
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
		classInstance.onActivityResult(arg0, arg1, arg2);
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub
		super.onAttachFragment(fragment);
		classInstance.onAttachFragment(fragment);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		classInstance.onBackPressed();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		classInstance.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		pluginFragmentActivityName = getClassName(this);
		
		if(pluginFragmentActivityName != null){
			classInstance = new PluginActivityFactory().orderParams(pluginFragmentActivityName,this);
		}
		
		if(classInstance != null)
			classInstance.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreatePanelMenu(int arg0, Menu arg1) {
		// TODO Auto-generated method stub
		
		classInstance.onCreatePanelMenu(arg0, arg1);
		
		return super.onCreatePanelMenu(arg0, arg1);
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		
		classInstance.onCreateView(name, context, attrs);
		
		return super.onCreateView(name, context, attrs);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		classInstance.onDestroy();
		
		super.onDestroy();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		classInstance.onKeyDown(keyCode, event);
		
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		
		classInstance.onLowMemory();
		
		super.onLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		
		classInstance.onMenuItemSelected(featureId, item);
		
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		
		classInstance.onNewIntent(intent);
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		super.onPanelClosed(featureId, menu);
		classInstance.onPanelClosed(featureId, menu);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		classInstance.onPause();
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		classInstance.onPostResume();
	}

	@Override
	public boolean onPreparePanel(int arg0, View arg1, Menu arg2) {
		// TODO Auto-generated method stub
		
		classInstance.onPreparePanel(arg0, arg1, arg2);
		
		return super.onPreparePanel(arg0, arg1, arg2);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		classInstance.onResume();
	}

	@Override
	protected void onResumeFragments() {
		// TODO Auto-generated method stub
		super.onResumeFragments();
		classInstance.onResumeFragments();
	}

	@Override
	public Object onRetainCustomNonConfigurationInstance() {
		// TODO Auto-generated method stub
		classInstance.onRetainCustomNonConfigurationInstance();
		return super.onRetainCustomNonConfigurationInstance();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		classInstance.onSaveInstanceState(outState);
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		classInstance.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		classInstance.onStop();
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode);
	}

	@Override
	public void startActivityFromFragment(Fragment fragment, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityFromFragment(fragment, intent, requestCode);
	}

	@Override
	public void supportInvalidateOptionsMenu() {
		// TODO Auto-generated method stub
		super.supportInvalidateOptionsMenu();
	}

	@Override
	public void addContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		super.addContentView(view, params);
	}

	@Override
	public void closeContextMenu() {
		// TODO Auto-generated method stub
		super.closeContextMenu();
	}

	@Override
	public void closeOptionsMenu() {
		// TODO Auto-generated method stub
		super.closeOptionsMenu();
	}

	@Override
	public PendingIntent createPendingResult(int requestCode, Intent data,
			int flags) {
		// TODO Auto-generated method stub
		return super.createPendingResult(requestCode, data, flags);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.dispatchGenericMotionEvent(ev);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return super.dispatchKeyEvent(event);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return super.dispatchKeyShortcutEvent(event);
	}

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		return super.dispatchPopulateAccessibilityEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.dispatchTrackballEvent(ev);
	}

	@Override
	public View findViewById(int id) {
		// TODO Auto-generated method stub
		return super.findViewById(id);
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
	}

	@Override
	public void finishActivity(int requestCode) {
		// TODO Auto-generated method stub
		super.finishActivity(requestCode);
	}

	@Override
	public void finishActivityFromChild(Activity child, int requestCode) {
		// TODO Auto-generated method stub
		super.finishActivityFromChild(child, requestCode);
	}

	@SuppressLint("NewApi")
	@Override
	public void finishAffinity() {
		// TODO Auto-generated method stub
		super.finishAffinity();
	}

	@Override
	public void finishFromChild(Activity child) {
		// TODO Auto-generated method stub
		super.finishFromChild(child);
	}

	@SuppressLint("NewApi")
	@Override
	public ActionBar getActionBar() {
		// TODO Auto-generated method stub
		return super.getActionBar();
	}

	@Override
	public ComponentName getCallingActivity() {
		// TODO Auto-generated method stub
		return super.getCallingActivity();
	}

	@Override
	public String getCallingPackage() {
		// TODO Auto-generated method stub
		return super.getCallingPackage();
	}

	@Override
	public int getChangingConfigurations() {
		// TODO Auto-generated method stub
		return super.getChangingConfigurations();
	}

	@Override
	public ComponentName getComponentName() {
		// TODO Auto-generated method stub
		return super.getComponentName();
	}

	@Override
	public View getCurrentFocus() {
		// TODO Auto-generated method stub
		return super.getCurrentFocus();
	}

	@SuppressLint("NewApi")
	@Override
	public android.app.FragmentManager getFragmentManager() {
		// TODO Auto-generated method stub
		return super.getFragmentManager();
	}

	@Override
	public Intent getIntent() {
		// TODO Auto-generated method stub
		return super.getIntent();
	}

	@Override
	public Object getLastNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return super.getLastNonConfigurationInstance();
	}

	@Override
	public LayoutInflater getLayoutInflater() {
		// TODO Auto-generated method stub
		return super.getLayoutInflater();
	}

	@SuppressLint("NewApi")
	@Override
	public android.app.LoaderManager getLoaderManager() {
		// TODO Auto-generated method stub
		return super.getLoaderManager();
	}

	@Override
	public String getLocalClassName() {
		// TODO Auto-generated method stub
		return super.getLocalClassName();
	}

	@Override
	public MenuInflater getMenuInflater() {
		// TODO Auto-generated method stub
		return super.getMenuInflater();
	}

	@SuppressLint("NewApi")
	@Override
	public Intent getParentActivityIntent() {
		// TODO Auto-generated method stub
		return super.getParentActivityIntent();
	}

	@Override
	public SharedPreferences getPreferences(int mode) {
		// TODO Auto-generated method stub
		return super.getPreferences(mode);
	}

	@Override
	public int getRequestedOrientation() {
		// TODO Auto-generated method stub
		return super.getRequestedOrientation();
	}

	@Override
	public Object getSystemService(String name) {
		// TODO Auto-generated method stub
		return super.getSystemService(name);
	}

	@Override
	public int getTaskId() {
		// TODO Auto-generated method stub
		return super.getTaskId();
	}

	@Override
	public Window getWindow() {
		// TODO Auto-generated method stub
		return super.getWindow();
	}

	@Override
	public WindowManager getWindowManager() {
		// TODO Auto-generated method stub
		return super.getWindowManager();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean hasWindowFocus() {
		// TODO Auto-generated method stub
		return super.hasWindowFocus();
	}

	@SuppressLint("NewApi")
	@Override
	public void invalidateOptionsMenu() {
		// TODO Auto-generated method stub
		super.invalidateOptionsMenu();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean isChangingConfigurations() {
		// TODO Auto-generated method stub
		return super.isChangingConfigurations();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return super.isDestroyed();
	}

	@Override
	public boolean isFinishing() {
		// TODO Auto-generated method stub
		return super.isFinishing();
	}

	@Override
	public boolean isTaskRoot() {
		// TODO Auto-generated method stub
		return super.isTaskRoot();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean moveTaskToBack(boolean nonRoot) {
		// TODO Auto-generated method stub
		return super.moveTaskToBack(nonRoot);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean navigateUpTo(Intent upIntent) {
		// TODO Auto-generated method stub
		return super.navigateUpTo(upIntent);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
		// TODO Auto-generated method stub
		return super.navigateUpToFromChild(child, upIntent);
	}

	@SuppressLint("NewApi")
	@Override
	public void onActionModeFinished(ActionMode mode) {
		// TODO Auto-generated method stub
		super.onActionModeFinished(mode);
		classInstance.onActionModeFinished(mode);
	}

	@SuppressLint("NewApi")
	@Override
	public void onActionModeStarted(ActionMode mode) {
		// TODO Auto-generated method stub
		super.onActionModeStarted(mode);
		classInstance.onActionModeStarted(mode);
	}

	@Override
	protected void onApplyThemeResource(Theme theme, int resid, boolean first) {
		// TODO Auto-generated method stub
		super.onApplyThemeResource(theme, resid, first);
		classInstance.onApplyThemeResource(theme, resid, first);
	}

	@SuppressLint("NewApi")
	@Override
	public void onAttachFragment(android.app.Fragment fragment) {
		// TODO Auto-generated method stub
		super.onAttachFragment(fragment);
		classInstance.onAttachFragment(fragment);
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
	}

	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		// TODO Auto-generated method stub
		super.onChildTitleChanged(childActivity, title);
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		super.onContentChanged();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onContextMenuClosed(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public CharSequence onCreateDescription() {
		// TODO Auto-generated method stub
		return super.onCreateDescription();
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(id);
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(id, args);
	}

	@SuppressLint("NewApi")
	@Override
	public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub
		super.onCreateNavigateUpTaskStack(builder);
		classInstance.onCreateNavigateUpTaskStack(builder);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public View onCreatePanelView(int featureId) {
		// TODO Auto-generated method stub
		return super.onCreatePanelView(featureId);
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		// TODO Auto-generated method stub
		return super.onCreateThumbnail(outBitmap, canvas);
	}

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		// TODO Auto-generated method stub
		classInstance.onCreateView(name, context, attrs);
		return super.onCreateView(parent, name, context, attrs);
	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		classInstance.onGenericMotionEvent(event);
		return super.onGenericMotionEvent(event);
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyLongPress(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		classInstance.onKeyShortcut(keyCode, event);
		return super.onKeyShortcut(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		classInstance.onKeyUp(keyCode, event);
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		classInstance.onMenuOpened(featureId, menu);
		return super.onMenuOpened(featureId, menu);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onNavigateUp() {
		// TODO Auto-generated method stub
		classInstance.onNavigateUp();
		return super.onNavigateUp();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onNavigateUpFromChild(Activity child) {
		// TODO Auto-generated method stub
		classInstance.onNavigateUpFromChild(child);
		return super.onNavigateUpFromChild(child);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		classInstance.onOptionsItemSelected(item);
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		classInstance.onOptionsMenuClosed(menu);
		super.onOptionsMenuClosed(menu);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		classInstance.onPostCreate(savedInstanceState);
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		classInstance.onPrepareDialog(id, dialog);
		super.onPrepareDialog(id, dialog);
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
		classInstance.onPrepareDialog(id, dialog, args);
		super.onPrepareDialog(id, dialog, args);
	}

	@SuppressLint("NewApi")
	@Override
	public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub
		classInstance.onPrepareNavigateUpTaskStack(builder);
		super.onPrepareNavigateUpTaskStack(builder);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		classInstance.onPrepareOptionsMenu(menu);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		classInstance.onRestart();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		classInstance.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		classInstance.onSearchRequested();
		return super.onSearchRequested();
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub
		super.onTitleChanged(title, color);
		classInstance.onTitleChanged(title, color);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		classInstance.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		classInstance.onTrackballEvent(event);
		return super.onTrackballEvent(event);
	}

	@SuppressLint("NewApi")
	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
		classInstance.onTrimMemory(level);
	}

	@Override
	public void onUserInteraction() {
		// TODO Auto-generated method stub
		super.onUserInteraction();
		classInstance.onUserInteraction();
	}

	@Override
	protected void onUserLeaveHint() {
		// TODO Auto-generated method stub
		super.onUserLeaveHint();
		classInstance.onUserLeaveHint();
	}

	@Override
	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams params) {
		// TODO Auto-generated method stub
		super.onWindowAttributesChanged(params);
		classInstance.onWindowAttributesChanged(params);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		classInstance.onWindowFocusChanged(hasFocus);
	}

	@SuppressLint("NewApi")
	@Override
	public ActionMode onWindowStartingActionMode(Callback callback) {
		// TODO Auto-generated method stub
		classInstance.onWindowStartingActionMode(callback);
		return super.onWindowStartingActionMode(callback);
	}

	@Override
	public void openContextMenu(View view) {
		// TODO Auto-generated method stub
		super.openContextMenu(view);
	}

	@Override
	public void openOptionsMenu() {
		// TODO Auto-generated method stub
		super.openOptionsMenu();
	}

	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		// TODO Auto-generated method stub
		super.overridePendingTransition(enterAnim, exitAnim);
	}

	@SuppressLint("NewApi")
	@Override
	public void recreate() {
		// TODO Auto-generated method stub
		super.recreate();
	}

	@Override
	public void registerForContextMenu(View view) {
		// TODO Auto-generated method stub
		super.registerForContextMenu(view);
	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		super.setContentView(layoutResID);
	}

	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		super.setContentView(view);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		super.setContentView(view, params);
	}

	@SuppressLint("NewApi")
	@Override
	public void setFinishOnTouchOutside(boolean finish) {
		// TODO Auto-generated method stub
		super.setFinishOnTouchOutside(finish);
	}

	@Override
	public void setIntent(Intent newIntent) {
		// TODO Auto-generated method stub
		super.setIntent(newIntent);
	}

	@Override
	public void setRequestedOrientation(int requestedOrientation) {
		// TODO Auto-generated method stub
		super.setRequestedOrientation(requestedOrientation);
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}

	@Override
	public void setTitle(int titleId) {
		// TODO Auto-generated method stub
		super.setTitle(titleId);
	}

	@Override
	public void setTitleColor(int textColor) {
		// TODO Auto-generated method stub
		super.setTitleColor(textColor);
	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		super.setVisible(visible);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean shouldUpRecreateTask(Intent targetIntent) {
		// TODO Auto-generated method stub
		return super.shouldUpRecreateTask(targetIntent);
	}

	@SuppressLint("NewApi")
	@Override
	public ActionMode startActionMode(Callback callback) {
		// TODO Auto-generated method stub
		return super.startActionMode(callback);
	}

	@Override
	public void startActivities(Intent[] intents) {
		// TODO Auto-generated method stub
		super.startActivities(intents);
	}

	@Override
	public void startActivities(Intent[] intents, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivities(intents, options);
	}

	@Override
	public void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		super.startActivity(intent);
	}

	@Override
	public void startActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivity(intent, options);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode, options);
	}

	@Override
	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityFromChild(child, intent, requestCode);
	}

	@Override
	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivityFromChild(child, intent, requestCode, options);
	}

	@Override
	public void startActivityFromFragment(android.app.Fragment fragment,
			Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityFromFragment(fragment, intent, requestCode);
	}

	@Override
	public void startActivityFromFragment(android.app.Fragment fragment,
			Intent intent, int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivityFromFragment(fragment, intent, requestCode, options);
	}

	@Override
	public boolean startActivityIfNeeded(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		return super.startActivityIfNeeded(intent, requestCode);
	}

	@Override
	public boolean startActivityIfNeeded(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		return super.startActivityIfNeeded(intent, requestCode, options);
	}

	@Override
	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags);
	}

	@Override
	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags, options);
	}

	@Override
	public void startIntentSenderForResult(IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
				flagsValues, extraFlags);
	}

	@Override
	public void startIntentSenderForResult(IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
				flagsValues, extraFlags, options);
	}

	@Override
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent,
				flagsMask, flagsValues, extraFlags);
	}

	@Override
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent,
				flagsMask, flagsValues, extraFlags, options);
	}

	@Override
	public void startManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		super.startManagingCursor(c);
	}

	@Override
	public boolean startNextMatchingActivity(Intent intent) {
		// TODO Auto-generated method stub
		return super.startNextMatchingActivity(intent);
	}

	@Override
	public boolean startNextMatchingActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		return super.startNextMatchingActivity(intent, options);
	}

	@Override
	public void startSearch(String initialQuery, boolean selectInitialQuery,
			Bundle appSearchData, boolean globalSearch) {
		// TODO Auto-generated method stub
		super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
	}

	@Override
	public void stopManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		super.stopManagingCursor(c);
	}

	@Override
	public void takeKeyEvents(boolean get) {
		// TODO Auto-generated method stub
		super.takeKeyEvents(get);
	}

	@Override
	public void triggerSearch(String query, Bundle appSearchData) {
		// TODO Auto-generated method stub
		super.triggerSearch(query, appSearchData);
	}

	@Override
	public void unregisterForContextMenu(View view) {
		// TODO Auto-generated method stub
		super.unregisterForContextMenu(view);
	}

	@Override
	public void applyOverrideConfiguration(Configuration overrideConfiguration) {
		// TODO Auto-generated method stub
		super.applyOverrideConfiguration(overrideConfiguration);
	}

	@Override
	protected void attachBaseContext(Context newBase) {
		// TODO Auto-generated method stub
		super.attachBaseContext(newBase);
	}

	@Override
	public Resources getResources() {
		// TODO Auto-generated method stub
		return super.getResources();
	}

	@Override
	public Theme getTheme() {
		// TODO Auto-generated method stub
		return super.getTheme();
	}

	@Override
	public void setTheme(int resid) {
		// TODO Auto-generated method stub
		super.setTheme(resid);
	}

	@Override
	public boolean bindService(Intent service, ServiceConnection conn, int flags) {
		// TODO Auto-generated method stub
		return super.bindService(service, conn, flags);
	}

	@Override
	public int checkCallingOrSelfPermission(String permission) {
		// TODO Auto-generated method stub
		return super.checkCallingOrSelfPermission(permission);
	}

	@Override
	public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		return super.checkCallingOrSelfUriPermission(uri, modeFlags);
	}

	@Override
	public int checkCallingPermission(String permission) {
		// TODO Auto-generated method stub
		return super.checkCallingPermission(permission);
	}

	@Override
	public int checkCallingUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		return super.checkCallingUriPermission(uri, modeFlags);
	}

	@Override
	public int checkPermission(String permission, int pid, int uid) {
		// TODO Auto-generated method stub
		return super.checkPermission(permission, pid, uid);
	}

	@Override
	public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		return super.checkUriPermission(uri, pid, uid, modeFlags);
	}

	@Override
	public int checkUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		return super.checkUriPermission(uri, readPermission, writePermission, pid, uid,
				modeFlags);
	}

	@Override
	public void clearWallpaper() throws IOException {
		// TODO Auto-generated method stub
		super.clearWallpaper();
	}

	@Override
	public Context createConfigurationContext(
			Configuration overrideConfiguration) {
		// TODO Auto-generated method stub
		return super.createConfigurationContext(overrideConfiguration);
	}

	@Override
	public Context createDisplayContext(Display display) {
		// TODO Auto-generated method stub
		return super.createDisplayContext(display);
	}

	@Override
	public Context createPackageContext(String packageName, int flags)
			throws NameNotFoundException {
		// TODO Auto-generated method stub
		return super.createPackageContext(packageName, flags);
	}

	@Override
	public String[] databaseList() {
		// TODO Auto-generated method stub
		return super.databaseList();
	}

	@Override
	public boolean deleteDatabase(String name) {
		// TODO Auto-generated method stub
		return super.deleteDatabase(name);
	}

	@Override
	public boolean deleteFile(String name) {
		// TODO Auto-generated method stub
		return super.deleteFile(name);
	}

	@Override
	public void enforceCallingOrSelfPermission(String permission, String message) {
		// TODO Auto-generated method stub
		super.enforceCallingOrSelfPermission(permission, message);
	}

	@Override
	public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
	}

	@Override
	public void enforceCallingPermission(String permission, String message) {
		// TODO Auto-generated method stub
		super.enforceCallingPermission(permission, message);
	}

	@Override
	public void enforceCallingUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		super.enforceCallingUriPermission(uri, modeFlags, message);
	}

	@Override
	public void enforcePermission(String permission, int pid, int uid,
			String message) {
		// TODO Auto-generated method stub
		super.enforcePermission(permission, pid, uid, message);
	}

	@Override
	public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		super.enforceUriPermission(uri, pid, uid, modeFlags, message);
	}

	@Override
	public void enforceUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		super.enforceUriPermission(uri, readPermission, writePermission, pid, uid,
				modeFlags, message);
	}

	@Override
	public String[] fileList() {
		// TODO Auto-generated method stub
		return super.fileList();
	}

	@Override
	public Context getApplicationContext() {
		// TODO Auto-generated method stub
		return super.getApplicationContext();
	}

	@Override
	public ApplicationInfo getApplicationInfo() {
		// TODO Auto-generated method stub
		return super.getApplicationInfo();
	}

	@Override
	public AssetManager getAssets() {
		// TODO Auto-generated method stub
		return super.getAssets();
	}

	@Override
	public Context getBaseContext() {
		// TODO Auto-generated method stub
		return super.getBaseContext();
	}

	@Override
	public File getCacheDir() {
		// TODO Auto-generated method stub
		return super.getCacheDir();
	}

	@Override
	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return super.getClassLoader();
	}

	@Override
	public ContentResolver getContentResolver() {
		// TODO Auto-generated method stub
		return super.getContentResolver();
	}

	@Override
	public File getDatabasePath(String name) {
		// TODO Auto-generated method stub
		return super.getDatabasePath(name);
	}

	@Override
	public File getDir(String name, int mode) {
		// TODO Auto-generated method stub
		return super.getDir(name, mode);
	}

	@Override
	public File getExternalCacheDir() {
		// TODO Auto-generated method stub
		return super.getExternalCacheDir();
	}

	@Override
	public File getExternalFilesDir(String type) {
		// TODO Auto-generated method stub
		return super.getExternalFilesDir(type);
	}

	@Override
	public File getFileStreamPath(String name) {
		// TODO Auto-generated method stub
		return super.getFileStreamPath(name);
	}

	@Override
	public File getFilesDir() {
		// TODO Auto-generated method stub
		return super.getFilesDir();
	}

	@Override
	public Looper getMainLooper() {
		// TODO Auto-generated method stub
		return super.getMainLooper();
	}

	@Override
	public File getObbDir() {
		// TODO Auto-generated method stub
		return super.getObbDir();
	}

	@Override
	public String getPackageCodePath() {
		// TODO Auto-generated method stub
		return super.getPackageCodePath();
	}

	@Override
	public PackageManager getPackageManager() {
		// TODO Auto-generated method stub
		return super.getPackageManager();
	}

	@Override
	public String getPackageName() {
		// TODO Auto-generated method stub
		return super.getPackageName();
	}

	@Override
	public String getPackageResourcePath() {
		// TODO Auto-generated method stub
		return super.getPackageResourcePath();
	}

	@Override
	public SharedPreferences getSharedPreferences(String name, int mode) {
		// TODO Auto-generated method stub
		return super.getSharedPreferences(name, mode);
	}

	@Override
	public Drawable getWallpaper() {
		// TODO Auto-generated method stub
		return super.getWallpaper();
	}

	@Override
	public int getWallpaperDesiredMinimumHeight() {
		// TODO Auto-generated method stub
		return super.getWallpaperDesiredMinimumHeight();
	}

	@Override
	public int getWallpaperDesiredMinimumWidth() {
		// TODO Auto-generated method stub
		return super.getWallpaperDesiredMinimumWidth();
	}

	@Override
	public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		super.grantUriPermission(toPackage, uri, modeFlags);
	}

	@Override
	public boolean isRestricted() {
		// TODO Auto-generated method stub
		return super.isRestricted();
	}

	@Override
	public FileInputStream openFileInput(String name)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return super.openFileInput(name);
	}

	@Override
	public FileOutputStream openFileOutput(String name, int mode)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return super.openFileOutput(name, mode);
	}

	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory) {
		// TODO Auto-generated method stub
		return super.openOrCreateDatabase(name, mode, factory);
	}

	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory, DatabaseErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		return super.openOrCreateDatabase(name, mode, factory, errorHandler);
	}

	@Override
	public Drawable peekWallpaper() {
		// TODO Auto-generated method stub
		return super.peekWallpaper();
	}

	@Override
	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter) {
		// TODO Auto-generated method stub
		return super.registerReceiver(receiver, filter);
	}

	@Override
	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter, String broadcastPermission, Handler scheduler) {
		// TODO Auto-generated method stub
		return super.registerReceiver(receiver, filter, broadcastPermission, scheduler);
	}

	@Override
	public void removeStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		super.removeStickyBroadcast(intent);
	}

	@Override
	public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		super.removeStickyBroadcastAsUser(intent, user);
	}

	@Override
	public void revokeUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		super.revokeUriPermission(uri, modeFlags);
	}

	@Override
	public void sendBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		super.sendBroadcast(intent);
	}

	@Override
	public void sendBroadcast(Intent intent, String receiverPermission) {
		// TODO Auto-generated method stub
		super.sendBroadcast(intent, receiverPermission);
	}

	@Override
	public void sendBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		super.sendBroadcastAsUser(intent, user);
	}

	@Override
	public void sendBroadcastAsUser(Intent intent, UserHandle user,
			String receiverPermission) {
		// TODO Auto-generated method stub
		super.sendBroadcastAsUser(intent, user, receiverPermission);
	}

	@Override
	public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
		// TODO Auto-generated method stub
		super.sendOrderedBroadcast(intent, receiverPermission);
	}

	@Override
	public void sendOrderedBroadcast(Intent intent, String receiverPermission,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver,
				scheduler, initialCode, initialData, initialExtras);
	}

	@Override
	public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user,
			String receiverPermission, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras) {
		// TODO Auto-generated method stub
		super.sendOrderedBroadcastAsUser(intent, user, receiverPermission,
				resultReceiver, scheduler, initialCode, initialData, initialExtras);
	}

	@Override
	public void sendStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		super.sendStickyBroadcast(intent);
	}

	@Override
	public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		super.sendStickyBroadcastAsUser(intent, user);
	}

	@Override
	public void sendStickyOrderedBroadcast(Intent intent,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		super.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler,
				initialCode, initialData, initialExtras);
	}

	@Override
	public void sendStickyOrderedBroadcastAsUser(Intent intent,
			UserHandle user, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras) {
		// TODO Auto-generated method stub
		super.sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler,
				initialCode, initialData, initialExtras);
	}

	@Override
	public void setWallpaper(Bitmap bitmap) throws IOException {
		// TODO Auto-generated method stub
		super.setWallpaper(bitmap);
	}

	@Override
	public void setWallpaper(InputStream data) throws IOException {
		// TODO Auto-generated method stub
		super.setWallpaper(data);
	}

	@Override
	public boolean startInstrumentation(ComponentName className,
			String profileFile, Bundle arguments) {
		// TODO Auto-generated method stub
		return super.startInstrumentation(className, profileFile, arguments);
	}

	@Override
	public ComponentName startService(Intent service) {
		// TODO Auto-generated method stub
		return super.startService(service);
	}

	@Override
	public boolean stopService(Intent name) {
		// TODO Auto-generated method stub
		return super.stopService(name);
	}

	@Override
	public void unbindService(ServiceConnection conn) {
		// TODO Auto-generated method stub
		super.unbindService(conn);
	}

	@Override
	public void unregisterReceiver(BroadcastReceiver receiver) {
		// TODO Auto-generated method stub
		super.unregisterReceiver(receiver);
	}

	@Override
	public void registerComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerComponentCallbacks(callback);
	}

	@Override
	public void unregisterComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterComponentCallbacks(callback);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return super.equals(o);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}