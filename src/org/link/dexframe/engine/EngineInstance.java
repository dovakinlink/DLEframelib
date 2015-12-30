package org.link.dexframe.engine;

import org.link.dexframe.DLEEngine;

/**
 * DLE向外公开的供运行时反射方法使用的DLE引擎实例
 * @author Link
 *
 */
public class EngineInstance {
	
	private static DLEEngine engine;
	
	public static void set(DLEEngine _engine){
		engine = _engine;
	}
	
	public static DLEEngine get(){
		return engine;
	}
	
}