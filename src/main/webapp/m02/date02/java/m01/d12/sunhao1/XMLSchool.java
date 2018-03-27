/**
 * Project Name:SIXwork
 * File Name:XMLSchool.java
 * Package Name:m01.d12.sunhao1
 * Date:2018年1月12日下午3:00:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.sunhao1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午3:00:56 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
/*
 * 实现思想： 1.构造一个文件对象 2.创建一个文件工厂 3.创建一个文件工人 4.解析文件(DoCument ??=工人.parse(File)
 * 5.获取XML文件的根标签列表(NodeList ?? =解析文件.getElementsByTagName(获取元素)
 */
public class XMLSchool {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\school1.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dm = db.parse(file);
            NodeList nl = dm.getElementsByTagName("school");
            Element element = dm.getDocumentElement();
            String val = element.getTextContent();
            System.out.println(val);

            for (int i = 0; i < nl.getLength(); i++) {
                System.out.print("作业：" + dm.getElementsByTagName("student").item(i).getFirstChild().getNodeValue());
                // NodeList childlist = dm.getElementsByTagName("name");
                // Node node = childlist.item(i);
                // Node first = node.getFirstChild();
                // String aa = first.getNodeValue();
                // System.out.println("我的作业" + aa);
            }

        } catch (ParserConfigurationException e) {

            e.printStackTrace();

        } catch (SAXException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
