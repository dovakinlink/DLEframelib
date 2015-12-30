package org.link.dexframe;

/**
 * DLE对启动后的DLP监听借口
 * @author Link
 *
 */
public interface DLPListener{
	
	/**
	 * DLP销毁时执行
	 */
	public void onPluginFinish();
	
}