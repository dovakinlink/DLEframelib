package org.link.dexplugin.activity;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import org.link.dexplugin.activity.factory.ConfigInfo;
import org.link.dexplugin.activity.proxy.ProxyActivity;

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
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.IntentSender.SendIntentException;
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
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ActionMode.Callback;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class PluginActivity {
	
	public Activity proxyActivity;  
	
	public void setActivity(Activity _proxyActivity){
		proxyActivity = _proxyActivity;
	}
	
	public void onCreate(Bundle savedInstanceState){}

	public void onDestroy(){}

	public void onPause(){}

	public void onRestart(){}

	public void onResume(){}
	
	
	public void addContentView(View view, LayoutParams params) {
	}

	public void closeContextMenu() {
		// TODO Auto-generated method stub
		proxyActivity.closeContextMenu();
	}

	public void closeOptionsMenu() {
		// TODO Auto-generated method stub
		proxyActivity.closeOptionsMenu();
	}

	public PendingIntent createPendingResult(int requestCode, Intent data,
			int flags) {
		// TODO Auto-generated method stub
		return proxyActivity.createPendingResult(requestCode, data, flags);
	}

	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean dispatchTrackballEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}

	public void dump(String prefix, FileDescriptor fd, PrintWriter writer,
			String[] args) {
		// TODO Auto-generated method stub
		proxyActivity.dump(prefix, fd, writer, args);
	}

	public View findViewById(int id) {
		// TODO Auto-generated method stub
		return proxyActivity.findViewById(id);
	}

	public void finish() {
		// TODO Auto-generated method stub
		proxyActivity.finish();
	}

	public void finishActivity(int requestCode) {
		// TODO Auto-generated method stub
		proxyActivity.finishActivity(requestCode);
	}

	public void finishActivityFromChild(Activity child, int requestCode) {
		// TODO Auto-generated method stub
		proxyActivity.finishActivityFromChild(child, requestCode);
	}

	public void finishAffinity() {
		// TODO Auto-generated method stub
		proxyActivity.finishAffinity();
	}

	public void finishFromChild(Activity child) {
		// TODO Auto-generated method stub
		proxyActivity.finishFromChild(child);
	}

	public ActionBar getActionBar() {
		// TODO Auto-generated method stub
		return proxyActivity.getActionBar();
	}

	public ComponentName getCallingActivity() {
		// TODO Auto-generated method stub
		return proxyActivity.getCallingActivity();
	}

	public String getCallingPackage() {
		// TODO Auto-generated method stub
		return proxyActivity.getCallingPackage();
	}

	public int getChangingConfigurations() {
		// TODO Auto-generated method stub
		return proxyActivity.getChangingConfigurations();
	}

	public ComponentName getComponentName() {
		// TODO Auto-generated method stub
		return proxyActivity.getComponentName();
	}

	public View getCurrentFocus() {
		// TODO Auto-generated method stub
		return proxyActivity.getCurrentFocus();
	}

	public FragmentManager getFragmentManager() {
		// TODO Auto-generated method stub
		return proxyActivity.getFragmentManager();
	}

	public Intent getIntent() {
		// TODO Auto-generated method stub
		return proxyActivity.getIntent();
	}

	public Object getLastNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return proxyActivity.getLastNonConfigurationInstance();
	}

	public LayoutInflater getLayoutInflater() {
		// TODO Auto-generated method stub
		return proxyActivity.getLayoutInflater();
	}

	public LoaderManager getLoaderManager() {
		// TODO Auto-generated method stub
		return proxyActivity.getLoaderManager();
	}

	public String getLocalClassName() {
		// TODO Auto-generated method stub
		return proxyActivity.getLocalClassName();
	}

	public MenuInflater getMenuInflater() {
		// TODO Auto-generated method stub
		return proxyActivity.getMenuInflater();
	}

	public Intent getParentActivityIntent() {
		// TODO Auto-generated method stub
		return proxyActivity.getParentActivityIntent();
	}

	public SharedPreferences getPreferences(int mode) {
		// TODO Auto-generated method stub
		return proxyActivity.getPreferences(mode);
	}

	public int getRequestedOrientation() {
		// TODO Auto-generated method stub
		return proxyActivity.getRequestedOrientation();
	}

	public Object getSystemService(String name) {
		// TODO Auto-generated method stub
		return proxyActivity.getSystemService(name);
	}

	public int getTaskId() {
		// TODO Auto-generated method stub
		return proxyActivity.getTaskId();
	}

	public Window getWindow() {
		// TODO Auto-generated method stub
		return proxyActivity.getWindow();
	}

	public WindowManager getWindowManager() {
		// TODO Auto-generated method stub
		return proxyActivity.getWindowManager();
	}

	public boolean hasWindowFocus() {
		// TODO Auto-generated method stub
		return proxyActivity.hasWindowFocus();
	}

	public void invalidateOptionsMenu() {
		// TODO Auto-generated method stub
		proxyActivity.invalidateOptionsMenu();
	}

	public boolean isChangingConfigurations() {
		// TODO Auto-generated method stub
		return proxyActivity.isChangingConfigurations();
	}

	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return proxyActivity.isDestroyed();
	}

	public boolean isFinishing() {
		// TODO Auto-generated method stub
		return proxyActivity.isFinishing();
	}

	public boolean isTaskRoot() {
		// TODO Auto-generated method stub
		return proxyActivity.isTaskRoot();
	}

	public boolean moveTaskToBack(boolean nonRoot) {
		// TODO Auto-generated method stub
		return proxyActivity.moveTaskToBack(nonRoot);
	}

	public boolean navigateUpTo(Intent upIntent) {
		// TODO Auto-generated method stub
		return proxyActivity.navigateUpTo(upIntent);
	}

	public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
		// TODO Auto-generated method stub
		return proxyActivity.navigateUpToFromChild(child, upIntent);
	}

	public void onActionModeFinished(ActionMode mode) {
		// TODO Auto-generated method stub
	}

	public void onActionModeStarted(ActionMode mode) {
		// TODO Auto-generated method stub
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
	}

	protected void onApplyThemeResource(Theme theme, int resid, boolean first) {
		// TODO Auto-generated method stub
	}

	public void onAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub
	}

	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
	}

	public void onBackPressed() {
		// TODO Auto-generated method stub
	}

	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		// TODO Auto-generated method stub
	}

	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
	}

	public void onContentChanged() {
		// TODO Auto-generated method stub
	}

	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onContextMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
	}

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
	}

	public CharSequence onCreateDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub
		return null;
	}

	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	public View onCreatePanelView(int featureId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		// TODO Auto-generated method stub
		return false;
	}

	public View onCreateView(String name, Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		return null;
	}

	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
	}

	public boolean onGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onLowMemory() {
		// TODO Auto-generated method stub
	}

	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onNavigateUp() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onNavigateUpFromChild(Activity child) {
		// TODO Auto-generated method stub
		return false;
	}

	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
	}

	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub
	}

	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	}

	protected void onPostResume() {
		// TODO Auto-generated method stub
	}

	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
	}

	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
	}

	public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub
	}

	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onPreparePanel(int featureId, View view, Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	}

	public Object onRetainNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
	}

	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void onStart() {
		// TODO Auto-generated method stub
	}

	protected void onStop() {
		// TODO Auto-generated method stub
	}

	protected void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub
	}

	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
	}

	public void onUserInteraction() {
		// TODO Auto-generated method stub
	}

	protected void onUserLeaveHint() {
		// TODO Auto-generated method stub
	}

	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams params) {
		// TODO Auto-generated method stub
	}

	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
	}

	public ActionMode onWindowStartingActionMode(Callback callback) {
		// TODO Auto-generated method stub
		return null;
	}

	public void openContextMenu(View view) {
		// TODO Auto-generated method stub
	}

	public void openOptionsMenu() {
		// TODO Auto-generated method stub
		proxyActivity.openOptionsMenu();
	}

	public void overridePendingTransition(int enterAnim, int exitAnim) {
		// TODO Auto-generated method stub
		proxyActivity.overridePendingTransition(enterAnim, exitAnim);
	}

	public void recreate() {
		// TODO Auto-generated method stub
		proxyActivity.recreate();
	}

	public void registerForContextMenu(View view) {
		// TODO Auto-generated method stub
		proxyActivity.registerForContextMenu(view);
	}

	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		proxyActivity.setContentView(layoutResID);
	}

	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		proxyActivity.setContentView(view, params);
	}

	public void setContentView(View view) {
		// TODO Auto-generated method stub
		proxyActivity.setContentView(view);
	}

	public void setFinishOnTouchOutside(boolean finish) {
		// TODO Auto-generated method stub
		proxyActivity.setFinishOnTouchOutside(finish);
	}

	public void setIntent(Intent newIntent) {
		// TODO Auto-generated method stub
		proxyActivity.setIntent(newIntent);
	}

	public void setRequestedOrientation(int requestedOrientation) {
		// TODO Auto-generated method stub
		proxyActivity.setRequestedOrientation(requestedOrientation);
	}

	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		proxyActivity.setTitle(title);
	}

	public void setTitle(int titleId) {
		// TODO Auto-generated method stub
		proxyActivity.setTitle(titleId);
	}

	public void setTitleColor(int textColor) {
		// TODO Auto-generated method stub
		proxyActivity.setTitleColor(textColor);
	}

	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		proxyActivity.setVisible(visible);
	}

	public boolean shouldUpRecreateTask(Intent targetIntent) {
		// TODO Auto-generated method stub
		return proxyActivity.shouldUpRecreateTask(targetIntent);
	}

	public ActionMode startActionMode(Callback callback) {
		// TODO Auto-generated method stub
		return proxyActivity.startActionMode(callback);
	}

	public void startActivities(Intent[] intents, Bundle options) {
		// TODO Auto-generated method stub
		proxyActivity.startActivities(intents, options);
	}

	public void startActivities(Intent[] intents) {
		// TODO Auto-generated method stub
		proxyActivity.startActivities(intents);
	}

	public void startActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		String classname = intent.getExtras().getString("classname");
		intent.setClass(proxyActivity, ConfigInfo.getActivityClass(classname));
		proxyActivity.startActivity(intent, options);
	}

	public void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		String classname = intent.getExtras().getString("classname");
		intent.setClass(proxyActivity, ConfigInfo.getActivityClass(classname));
		proxyActivity.startActivity(intent);
	}
	

	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		proxyActivity.startActivityForResult(intent, requestCode, options);
	}

	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		proxyActivity.startActivityForResult(intent, requestCode);
	}

	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		proxyActivity.startActivityFromChild(child, intent, requestCode, options);
	}

	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		proxyActivity.startActivityFromChild(child, intent, requestCode);
	}

	public void startActivityFromFragment(Fragment fragment, Intent intent,
			int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		proxyActivity.startActivityFromFragment(fragment, intent, requestCode, options);
	}

	public void startActivityFromFragment(Fragment fragment, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		proxyActivity.startActivityFromFragment(fragment, intent, requestCode);
	}

	public boolean startActivityIfNeeded(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		return proxyActivity.startActivityIfNeeded(intent, requestCode, options);
	}

	public boolean startActivityIfNeeded(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		return proxyActivity.startActivityIfNeeded(intent, requestCode);
	}

	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		proxyActivity.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags, options);
	}

	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags)
			throws SendIntentException {
		// TODO Auto-generated method stub
		proxyActivity.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags);
	}

	public void startIntentSenderForResult(IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		proxyActivity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
				flagsValues, extraFlags, options);
	}

	public void startIntentSenderForResult(IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		proxyActivity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
				flagsValues, extraFlags);
	}

	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		proxyActivity.startIntentSenderFromChild(child, intent, requestCode, fillInIntent,
				flagsMask, flagsValues, extraFlags, options);
	}

	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		proxyActivity.startIntentSenderFromChild(child, intent, requestCode, fillInIntent,
				flagsMask, flagsValues, extraFlags);
	}

	public void startManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		proxyActivity.startManagingCursor(c);
	}

	public boolean startNextMatchingActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		return proxyActivity.startNextMatchingActivity(intent, options);
	}

	public boolean startNextMatchingActivity(Intent intent) {
		// TODO Auto-generated method stub
		return proxyActivity.startNextMatchingActivity(intent);
	}

	public void startSearch(String initialQuery, boolean selectInitialQuery,
			Bundle appSearchData, boolean globalSearch) {
		// TODO Auto-generated method stub
		proxyActivity.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
	}

	public void stopManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		proxyActivity.stopManagingCursor(c);
	}

	public void takeKeyEvents(boolean get) {
		// TODO Auto-generated method stub
		proxyActivity.takeKeyEvents(get);
	}

	public void triggerSearch(String query, Bundle appSearchData) {
		// TODO Auto-generated method stub
		proxyActivity.triggerSearch(query, appSearchData);
	}

	public void unregisterForContextMenu(View view) {
		// TODO Auto-generated method stub
		proxyActivity.unregisterForContextMenu(view);
	}

	public void applyOverrideConfiguration(Configuration overrideConfiguration) {
		// TODO Auto-generated method stub
		proxyActivity.applyOverrideConfiguration(overrideConfiguration);
	}

	/**
	 * protected
	 * @param newBase
	 */
/*	protected void attachBaseContext(Context newBase) {
		// TODO Auto-generated method stub
		proxyActivity.attachBaseContext(newBase);
	}*/

	/**
	 * 123
	 * @return
	 */
	public Resources getResources() {
		// TODO Auto-generated method stub
		return proxyActivity.getResources();
	}

	public Theme getTheme() {
		// TODO Auto-generated method stub
		return proxyActivity.getTheme();
	}

	public void setTheme(int resid) {
		// TODO Auto-generated method stub
		proxyActivity.setTheme(resid);
	}

	public boolean bindService(Intent service, ServiceConnection conn, int flags) {
		// TODO Auto-generated method stub
		return proxyActivity.bindService(service, conn, flags);
	}

	public int checkCallingOrSelfPermission(String permission) {
		// TODO Auto-generated method stub
		return proxyActivity.checkCallingOrSelfPermission(permission);
	}

	public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		return proxyActivity.checkCallingOrSelfUriPermission(uri, modeFlags);
	}

	public int checkCallingPermission(String permission) {
		// TODO Auto-generated method stub
		return proxyActivity.checkCallingPermission(permission);
	}

	public int checkCallingUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		return proxyActivity.checkCallingUriPermission(uri, modeFlags);
	}

	public int checkPermission(String permission, int pid, int uid) {
		// TODO Auto-generated method stub
		return proxyActivity.checkPermission(permission, pid, uid);
	}

	public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		return proxyActivity.checkUriPermission(uri, pid, uid, modeFlags);
	}

	public int checkUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		return proxyActivity.checkUriPermission(uri, readPermission, writePermission, pid, uid,
				modeFlags);
	}

	public void clearWallpaper() throws IOException {
		// TODO Auto-generated method stub
		proxyActivity.clearWallpaper();
	}

	public Context createConfigurationContext(
			Configuration overrideConfiguration) {
		// TODO Auto-generated method stub
		return proxyActivity.createConfigurationContext(overrideConfiguration);
	}

	public Context createDisplayContext(Display display) {
		// TODO Auto-generated method stub
		return proxyActivity.createDisplayContext(display);
	}

	public Context createPackageContext(String packageName, int flags)
			throws NameNotFoundException {
		// TODO Auto-generated method stub
		return proxyActivity.createPackageContext(packageName, flags);
	}

	public String[] databaseList() {
		// TODO Auto-generated method stub
		return proxyActivity.databaseList();
	}

	public boolean deleteDatabase(String name) {
		// TODO Auto-generated method stub
		return proxyActivity.deleteDatabase(name);
	}

	public boolean deleteFile(String name) {
		// TODO Auto-generated method stub
		return proxyActivity.deleteFile(name);
	}

	public void enforceCallingOrSelfPermission(String permission, String message) {
		// TODO Auto-generated method stub
		proxyActivity.enforceCallingOrSelfPermission(permission, message);
	}

	public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		proxyActivity.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
	}

	public void enforceCallingPermission(String permission, String message) {
		// TODO Auto-generated method stub
		proxyActivity.enforceCallingPermission(permission, message);
	}

	public void enforceCallingUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		proxyActivity.enforceCallingUriPermission(uri, modeFlags, message);
	}

	public void enforcePermission(String permission, int pid, int uid,
			String message) {
		// TODO Auto-generated method stub
		proxyActivity.enforcePermission(permission, pid, uid, message);
	}

	public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		proxyActivity.enforceUriPermission(uri, pid, uid, modeFlags, message);
	}

	public void enforceUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		proxyActivity.enforceUriPermission(uri, readPermission, writePermission, pid, uid,
				modeFlags, message);
	}

	public String[] fileList() {
		// TODO Auto-generated method stub
		return proxyActivity.fileList();
	}

	public Context getApplicationContext() {
		// TODO Auto-generated method stub
		return proxyActivity.getApplicationContext();
	}

	public ApplicationInfo getApplicationInfo() {
		// TODO Auto-generated method stub
		return proxyActivity.getApplicationInfo();
	}

	public AssetManager getAssets() {
		// TODO Auto-generated method stub
		return proxyActivity.getAssets();
	}

	public Context getBaseContext() {
		// TODO Auto-generated method stub
		return proxyActivity.getBaseContext();
	}

	public File getCacheDir() {
		// TODO Auto-generated method stub
		return proxyActivity.getCacheDir();
	}

	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return proxyActivity.getClassLoader();
	}

	public ContentResolver getContentResolver() {
		// TODO Auto-generated method stub
		return proxyActivity.getContentResolver();
	}

	public File getDatabasePath(String name) {
		// TODO Auto-generated method stub
		return proxyActivity.getDatabasePath(name);
	}

	public File getDir(String name, int mode) {
		// TODO Auto-generated method stub
		return proxyActivity.getDir(name, mode);
	}

	public File getExternalCacheDir() {
		// TODO Auto-generated method stub
		return proxyActivity.getExternalCacheDir();
	}

	public File getExternalFilesDir(String type) {
		// TODO Auto-generated method stub
		return proxyActivity.getExternalFilesDir(type);
	}

	public File getFileStreamPath(String name) {
		// TODO Auto-generated method stub
		return proxyActivity.getFileStreamPath(name);
	}

	public File getFilesDir() {
		// TODO Auto-generated method stub
		return proxyActivity.getFilesDir();
	}

	public Looper getMainLooper() {
		// TODO Auto-generated method stub
		return proxyActivity.getMainLooper();
	}

	public File getObbDir() {
		// TODO Auto-generated method stub
		return proxyActivity.getObbDir();
	}

	public String getPackageCodePath() {
		// TODO Auto-generated method stub
		return proxyActivity.getPackageCodePath();
	}

	public PackageManager getPackageManager() {
		// TODO Auto-generated method stub
		return proxyActivity.getPackageManager();
	}

	public String getPackageName() {
		// TODO Auto-generated method stub
		return proxyActivity.getPackageName();
	}

	public String getPackageResourcePath() {
		// TODO Auto-generated method stub
		return proxyActivity.getPackageResourcePath();
	}

	public SharedPreferences getSharedPreferences(String name, int mode) {
		// TODO Auto-generated method stub
		return proxyActivity.getSharedPreferences(name, mode);
	}

	public Drawable getWallpaper() {
		// TODO Auto-generated method stub
		return proxyActivity.getWallpaper();
	}

	public int getWallpaperDesiredMinimumHeight() {
		// TODO Auto-generated method stub
		return proxyActivity.getWallpaperDesiredMinimumHeight();
	}

	public int getWallpaperDesiredMinimumWidth() {
		// TODO Auto-generated method stub
		return proxyActivity.getWallpaperDesiredMinimumWidth();
	}

	public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		proxyActivity.grantUriPermission(toPackage, uri, modeFlags);
	}

	public boolean isRestricted() {
		// TODO Auto-generated method stub
		return proxyActivity.isRestricted();
	}

	public FileInputStream openFileInput(String name)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return proxyActivity.openFileInput(name);
	}

	public FileOutputStream openFileOutput(String name, int mode)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return proxyActivity.openFileOutput(name, mode);
	}

	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory) {
		// TODO Auto-generated method stub
		return proxyActivity.openOrCreateDatabase(name, mode, factory);
	}

	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory, DatabaseErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		return proxyActivity.openOrCreateDatabase(name, mode, factory, errorHandler);
	}

	public Drawable peekWallpaper() {
		// TODO Auto-generated method stub
		return proxyActivity.peekWallpaper();
	}

	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter) {
		// TODO Auto-generated method stub
		return proxyActivity.registerReceiver(receiver, filter);
	}

	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter, String broadcastPermission, Handler scheduler) {
		// TODO Auto-generated method stub
		return proxyActivity.registerReceiver(receiver, filter, broadcastPermission, scheduler);
	}

	public void removeStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		proxyActivity.removeStickyBroadcast(intent);
	}

	public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		proxyActivity.removeStickyBroadcastAsUser(intent, user);
	}

	public void revokeUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		proxyActivity.revokeUriPermission(uri, modeFlags);
	}

	public void sendBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		proxyActivity.sendBroadcast(intent);
	}

	public void sendBroadcast(Intent intent, String receiverPermission) {
		// TODO Auto-generated method stub
		proxyActivity.sendBroadcast(intent, receiverPermission);
	}

	public void sendBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		proxyActivity.sendBroadcastAsUser(intent, user);
	}

	public void sendBroadcastAsUser(Intent intent, UserHandle user,
			String receiverPermission) {
		// TODO Auto-generated method stub
		proxyActivity.sendBroadcastAsUser(intent, user, receiverPermission);
	}

	public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
		// TODO Auto-generated method stub
		proxyActivity.sendOrderedBroadcast(intent, receiverPermission);
	}

	public void sendOrderedBroadcast(Intent intent, String receiverPermission,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		proxyActivity.sendOrderedBroadcast(intent, receiverPermission, resultReceiver,
				scheduler, initialCode, initialData, initialExtras);
	}

	public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user,
			String receiverPermission, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras) {
		// TODO Auto-generated method stub
		proxyActivity.sendOrderedBroadcastAsUser(intent, user, receiverPermission,
				resultReceiver, scheduler, initialCode, initialData, initialExtras);
	}

	public void sendStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		proxyActivity.sendStickyBroadcast(intent);
	}

	public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		proxyActivity.sendStickyBroadcastAsUser(intent, user);
	}

	public void sendStickyOrderedBroadcast(Intent intent,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		proxyActivity.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler,
				initialCode, initialData, initialExtras);
	}

	public void sendStickyOrderedBroadcastAsUser(Intent intent,
			UserHandle user, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras) {
		// TODO Auto-generated method stub
		proxyActivity.sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler,
				initialCode, initialData, initialExtras);
	}

	public void setWallpaper(Bitmap bitmap) throws IOException {
		// TODO Auto-generated method stub
		proxyActivity.setWallpaper(bitmap);
	}

	public void setWallpaper(InputStream data) throws IOException {
		// TODO Auto-generated method stub
		proxyActivity.setWallpaper(data);
	}

	public boolean startInstrumentation(ComponentName className,
			String profileFile, Bundle arguments) {
		// TODO Auto-generated method stub
		return proxyActivity.startInstrumentation(className, profileFile, arguments);
	}

	public ComponentName startService(Intent service) {
		// TODO Auto-generated method stub
		return proxyActivity.startService(service);
	}

	public boolean stopService(Intent name) {
		// TODO Auto-generated method stub
		return proxyActivity.stopService(name);
	}

	public void unbindService(ServiceConnection conn) {
		// TODO Auto-generated method stub
		proxyActivity.unbindService(conn);
	}

	public void unregisterReceiver(BroadcastReceiver receiver) {
		// TODO Auto-generated method stub
		proxyActivity.unregisterReceiver(receiver);
	}

	public void registerComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		proxyActivity.registerComponentCallbacks(callback);
	}

	public void unregisterComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		proxyActivity.unregisterComponentCallbacks(callback);
	}

	/**
	 * protected
	 */
/*	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return proxyActivity.clone();
	}*/

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return proxyActivity.equals(o);
	}

	/**
	 * protected
	 */
/*	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		proxyActivity.finalize();
	}*/

	public int hashCode() {
		// TODO Auto-generated method stub
		return proxyActivity.hashCode();
	}

	public String toString() {
		// TODO Auto-generated method stub
		return proxyActivity.toString();
	}
	
	public void finishDLP(){
		Class clazz = null;
		
		try {
			clazz = Class.forName("org.link.dexframe.DLP");
			Object obj = clazz.newInstance();
			clazz.getMethod("finish").invoke(obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}