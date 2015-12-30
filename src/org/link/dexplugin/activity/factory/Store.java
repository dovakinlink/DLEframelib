package org.link.dexplugin.activity.factory;

import java.util.List;

import org.link.dexplugin.activity.PluginActivity;
import org.link.dexplugin.activity.PluginFragmentActivity;
import org.link.dexplugin.activity.proxy.ProxyActivity;
import org.link.dexplugin.activity.proxy.ProxyFragmentActivity;


public abstract class Store{
	
	public PluginActivity orderParams(String questParam, ProxyActivity pa){
		PluginActivity param;
		
		param = createParams(questParam,pa);
		
		return param;
	}
	
	public PluginFragmentActivity orderParams(String questParam, ProxyFragmentActivity pa){
		PluginFragmentActivity param;
		
		param = createParams(questParam,pa);
		
		return param;
	}
	
	protected abstract PluginActivity createParams(String questParam,ProxyActivity pa);
	
	protected abstract PluginFragmentActivity createParams(String questParam,ProxyFragmentActivity pa);
}