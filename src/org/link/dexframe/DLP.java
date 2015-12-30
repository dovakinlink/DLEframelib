package org.link.dexframe;

import org.link.dexframe.engine.EngineInstance;

/**
 * DLP反射调用方法类
 * @author Link
 *
 */
public class DLP {
	
	/**
	 * 当DLP插件销毁时反射调用
	 */
	public void finish(){
		EngineInstance.get().getDLPListener().onPluginFinish();
	}
}