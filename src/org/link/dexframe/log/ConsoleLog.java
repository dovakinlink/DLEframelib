package org.link.dexframe.log;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志输出类
 * 面向开发人员，用于记录输出DLE运行状态及错误信息
 * @author Link
 * @version 1.0
 */
@SuppressLint("SimpleDateFormat")
public class ConsoleLog {
	
	private static Boolean isUseable = true;
	
	private static Date date;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 设置日志输出是否可用
	 * @param bool 布尔值
	 */
	public static void setEnable(Boolean bool){
		isUseable = bool;
	}
	
	/**
	 * 日志打印
	 * @param logmessage 日志信息
	 */
	public static void out(String logmessage){
		
		if(!isUseable) return;
		
		date = new Date(System.currentTimeMillis());
		System.out.println(logmessage + " " + sdf.format(date));
	}
	
	/**
	 * 日志打印
	 * @param logmessage 日志信息
	 * @param obj 操作对象
	 */
	public static void out(String logmessage, Object obj){
		
		if(!isUseable) return;
		
		date = new Date(System.currentTimeMillis());
		System.out.println(logmessage + "(" + obj + ")" + " " + sdf.format(date));
	}
	
}