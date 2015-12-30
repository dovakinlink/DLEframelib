package org.link.dexplugin.activity.factory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PluginParser {
	private DocumentBuilderFactory docBuilderFactory = null;
	private DocumentBuilder docBuilder = null;
	private Document doc = null;

	public Document getDoc() {
		return doc;
	}

	/**
	 * 构造函数
	 * @param msg XML字符串
	 */
	public PluginParser(String msg) {
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();

			ByteArrayInputStream stream = new ByteArrayInputStream(msg
					.getBytes());
			doc = docBuilder.parse(stream);

		} catch (IOException e) {
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 取指定节点值
	 * @param name 节点名称
	 * @return     节点值
	 */
	public String getElementValue(String name) {
		try {
		if (doc != null) {
			Element docEle = doc.getDocumentElement();
			NodeList nl = docEle.getElementsByTagName(name);
			Node node = null;
			if (nl.getLength() > 0) {
				node = nl.item(0).getFirstChild();
			} else
				return "";
			String res = node.getNodeValue();
			return res;
		} else {
			return "";
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return "";
	}
	}

	/**
	* 取返回结果中某一字段对应的值,默认取第一条记录的值
	*
	*@param 字段名
	*@return 取返回结果中某一字段对应的值,默认取第一条记录的值
    */
	public String getFieldPointValue(String fieldname) {
		try {
			if (doc == null) {
				return "";
			}
			NodeList xnl = doc.getElementsByTagName("Row");
			if (xnl == null || xnl.getLength() < 3) {
				return "";
			}
			Node xn = xnl.item(0);

			int fieldpoint = -1;
			for (int i = 0; i < xn.getChildNodes().getLength(); i++) {
				if (xn.getChildNodes().item(i).getFirstChild().getNodeValue()
						.equals(fieldname)) {
					fieldpoint = i;
					break;
				}
			}
			if (fieldpoint != -1) {
				Node vxn = xnl.item(2);
				if (vxn.getChildNodes().getLength() >= fieldpoint) {
					if (vxn.getChildNodes().item(fieldpoint).getFirstChild() != null) {
						return vxn.getChildNodes().item(fieldpoint).getFirstChild()
								.getNodeValue();
					}
				}
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	
	/** 取返回结果中某一字段对应的值的代码属性,默认取第一条记录的值的属性
	* 如果不是代码[没有属性]，则返回节点值
	*
	*@param  字段名
	*@return 返回属性值
	*/
	public String getFieldPointAttribute(String fieldname) {
		try {
			if (doc == null) {
				return "";
			}
			NodeList xnl = doc.getElementsByTagName("Row");
			if (xnl == null || xnl.getLength() < 3) {
				return "";
			}
			Node xn = xnl.item(0);
			
			int fieldpoint = -1;
			for (int i = 0; i < xn.getChildNodes().getLength(); i++) {
				if (xn.getChildNodes().item(i).getFirstChild().getNodeValue()
						.equals(fieldname)) {
					fieldpoint = i;
					break;
				}
			}
			if (fieldpoint != -1) {
				Node vxn = xnl.item(2);
				if (vxn.getChildNodes().getLength() >= fieldpoint) {
					if (vxn.getChildNodes().item(fieldpoint).getAttributes()
							.getLength() > 1) {
						if (vxn.getChildNodes().item(fieldpoint).getAttributes()
								.getNamedItem("IsCode").getNodeValue().equals("1")) {
							return vxn.getChildNodes().item(fieldpoint)
									.getAttributes().getNamedItem("CodeValue")
									.getNodeValue();
						} else {
							if (vxn.getChildNodes().item(fieldpoint)
									.getFirstChild() != null) {
								return vxn.getChildNodes().item(fieldpoint)
										.getFirstChild().getNodeValue();
							}
						}
					} else {
						return vxn.getChildNodes().item(fieldpoint).getFirstChild()
								.getNodeValue();
					}
				}
			}
		} catch (Exception e) {
			return "";
		}
		
		return "";
	}

	/**
	*获取XML配置节点中的某一字段的位置
	*
	*@param  XML节点
	*@param  字段名
	*@return 位置,如果找不到,返回-1
	*/
	public int getPoint(Node xn, String fieldname) {
		if (null != xn) {
			if (xn.getChildNodes().getLength() >= 1) {
				for (int i = 0; i < xn.getChildNodes().getLength(); i++) {
					if (xn.getChildNodes().item(i).getFirstChild()
							.getNodeValue().equals(fieldname)) {
						return (i);
					}
				}
			}
		}

		return (-1);
	}
    /**
     * 获取某个节点下的集合
     * @param fieldName
     * @return  返回节点集合 ，如果没有则NULL
     * 
     */
	public NodeList getNodeList(String fieldName)
    {
    	if (doc == null) {
			return null;
		}
		NodeList xnl = doc.getElementsByTagName(fieldName);
		if (xnl == null || xnl.getLength() < 1) {
			return null;
		}
		return xnl;
    }
	/**
	* 取返回结果中某一字段对应的值,可以指定取哪一行的数据值
	*
	*@param 字段名
	*@param 记录行数
	*@return 返回数据 
	*/
	public String getFieldPointValue(String fieldname, int rowno) {
		if (doc == null) {
			return "";
		}
		NodeList xnl = doc.getElementsByTagName("Row");
		if (xnl == null || xnl.getLength() < 1) {
			return "";
		}
		Node xn = xnl.item(0);
		if (xnl.getLength() < rowno) {
			return "";
		}
		int fieldpoint = -1;
		for (int i = 0; i < xn.getChildNodes().getLength(); i++) {
			if (xn.getChildNodes().item(i).getFirstChild().getNodeValue()
					.equals(fieldname)) {
				fieldpoint = i;
				break;
			}
		}
		if (fieldpoint != -1) {
			Node vxn = xnl.item(rowno);
			if (vxn.getChildNodes().getLength() >= fieldpoint) {
				if (vxn.getChildNodes().item(fieldpoint).getFirstChild() != null)
				return vxn.getChildNodes().item(fieldpoint).getFirstChild()
						.getNodeValue();
			}
		}
		return "";
	}

	/**
	*取返回结果中某一字段对应的值的代码属性,可以指定取哪个行的数据值
	* 如果不是代码[没有属性]，则返回节点值
	*@param 字段名
	*@param 记录编号
	*@return  返回数据
	*/
	public String getFieldPointAttribute(String fieldname, int rowno) {
		if (doc == null) {
			return "";
		}
		NodeList xnl = doc.getElementsByTagName("Row");
		if (xnl == null || xnl.getLength() < 1) {
			return "";
		}
		if (xnl.getLength() < rowno) {
			return "";
		}
		Node xn = xnl.item(0);
		int fieldpoint = -1;
		for (int i = 0; i < xn.getChildNodes().getLength(); i++) {
			if (xn.getChildNodes().item(i).getFirstChild().getNodeValue()
					.equals(fieldname)) {
				fieldpoint = i;
				break;
			}
		}
		if (fieldpoint != -1) {
			Node vxn = xnl.item(rowno);
			if (vxn.getChildNodes().getLength() >= fieldpoint) {
				if (vxn.getChildNodes().item(fieldpoint).getAttributes()
						.getLength() > 1) {
					if (vxn.getChildNodes().item(fieldpoint).getAttributes()
							.getNamedItem("IsCode").getNodeValue().equals("1")) {
						return vxn.getChildNodes().item(fieldpoint)
								.getAttributes().getNamedItem("CodeValue")
								.getNodeValue();

					} else {
						if (vxn.getChildNodes().item(fieldpoint)
								.getFirstChild() != null)
						return vxn.getChildNodes().item(fieldpoint)
								.getFirstChild().getNodeValue();
					}
				} else {
					if (vxn.getChildNodes().item(fieldpoint)
							.getFirstChild() != null)
					return vxn.getChildNodes().item(fieldpoint).getFirstChild()
							.getNodeValue();
				}
			}
		}
		return "";
	}

}
