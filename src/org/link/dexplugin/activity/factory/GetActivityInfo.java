package org.link.dexplugin.activity.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.widget.Toast;

/**
 * 解析assets文件夹下的xml文件
 * 
 * @author szj
 * 
 */
public class GetActivityInfo {

	private Context context;// 上下文
	private String content = "";// 文件内容
	private List<ActivityInfo> ActivityInfoList = new ArrayList<ActivityInfo>();

	private static GetActivityInfo instance = null;
	
	private Boolean isParsed = false;
	
	private final String filename = "activityConfig.xml";
	
	private HashMap<String ,String > classMap = new HashMap<String, String>();
	
	/**
	 * 构造函数
	 * 
	 * @param context
	 *            上下文
	 * @param filename
	 *            文件名
	 */
	
	private GetActivityInfo(Context context){
		this.context = context;
		classMap.put("PluginActivity", "org.link.dexplugin.activity.proxy.ProxyActivity");
		classMap.put("PluginFragmentActivity", "org.link.dexplugin.activity.proxy.ProxyFragmentActivity");
	}
	
	public static GetActivityInfo getInstance(Context context) {
		
		if(instance != null){
			return instance;
		}
		
		instance = new GetActivityInfo(context);
		return instance;
	}

	/**
	 * 解析xml文件获得信息bean
	 * 
	 * @return
	 */
	public List<ActivityInfo> parseXml() {

		if(isParsed) return ActivityInfoList;
		
		getXmlInfo();
		getBean();
		return ActivityInfoList;
	}

	/**
	 * 获取xml文件内容
	 */
	private void getXmlInfo() {

		content = "";
		// 读取assets文件夹下指定文件信息
		try {
			InputStream instream = context.getResources().getAssets()
					.open(filename);
			if (instream != null) {
				InputStreamReader inputreader = new InputStreamReader(instream);
				BufferedReader buffreader = new BufferedReader(inputreader);
				String line;
				// 分行读取
				while ((line = buffreader.readLine()) != null) {
					content += line;
				}
				instream.close();
				inputreader.close();
				buffreader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			content = "00";
		}

	}

	/**
	 * 获取信息bean
	 */
	private void getBean() {

		ActivityInfoList.clear();
		content = content.replace("\t", "").replace("\\", "").replace("\n", "");
		
		if (content.equals("00")) {
			Toast.makeText(context, "文件解析失败", Toast.LENGTH_LONG).show();
			return;
		} else if (content.equals("")) {
			Toast.makeText(context, "xml文件无数据", Toast.LENGTH_LONG).show();
			return;
		}

		PluginParser xp = new PluginParser(content);
		if (xp.getDoc() == null) {
			Toast.makeText(context, "xml文件格式不正确", Toast.LENGTH_LONG).show();
			return;
		}

		Document doc = xp.getDoc();
		NodeList xnl = doc.getElementsByTagName("activity");
		if (xnl == null || xnl.getLength() < 1) {
			Toast.makeText(context, "获取数据失败", Toast.LENGTH_LONG).show();
			return;
		}

		for (int i = 0; i < xnl.getLength(); i++) {

			NodeList activity = xnl.item(i).getChildNodes();
			ActivityInfo activityInfo = new ActivityInfo();
			String name = activity.item(1).getTextContent();
			String type = activity.item(3).getTextContent();
			String ismain = activity.item(5).getTextContent();

			activityInfo.setName(name);
			activityInfo.setType(classMap.get(type));
			if (ismain.equals("true")) {
				activityInfo.setIsMain(true);
			} else if (ismain.equals("false")) {
				activityInfo.setIsMain(false);
			}
			ActivityInfoList.add(activityInfo);
		}
	}

}
