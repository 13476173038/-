/**
 * Project Name:Byron
 * File Name:XmlReader.java
 * Package Name:Xml
 * Date:2018年1月12日下午3:37:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.WangHaoyang;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午3:37:44 <br/>
 * 
 * @author WangHaoyang
 * @version
 * @see
 */
public class XmlReader {

    public static void main(String[] args) {
        long lasting = System.currentTimeMillis();
        try {
            File f = new File("E:\\school.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder bd = dbf.newDocumentBuilder();
            Document doc = bd.parse(f);
            NodeList nl = doc.getElementsByTagName("school");
            Element el = doc.getDocumentElement();
            String nodeVal = el.getTextContent();
            System.out.println("val:" + nodeVal);// 遍历输出所有文本信息

            for (int i = 0; i < nl.getLength(); i++) {
                NodeList childList = doc.getElementsByTagName("studentName");
                Node node = childList.item(i);
                Node fNode = node.getFirstChild();
                String no = fNode.getNodeValue();
                System.out.println("名字:" + no);
                System.out.println("年龄：" + doc.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());
                System.out.println("性别：" + doc.getElementsByTagName("sex").item(i).getFirstChild().getNodeValue());// 只能get第一个学生，不能get其他学生吗

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
