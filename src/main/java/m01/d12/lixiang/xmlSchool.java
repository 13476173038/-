/**
 * Project Name:Lesson3
 * File Name:xmlSchool.java
 * Package Name:less0112
 * Date:2018年1月12日下午2:06:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.lixiang;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xmlSchool {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File("D:\\myDoc\\School.xml");  
            Document doc = db.parse(file);

            NodeList nl = doc.getElementsByTagName("class");
            for (int i = 0; i < nl.getLength(); i++) { 
                Node classI = nl.item(i); 

                Element ele = (Element) classI; 
                String attrValue = ele.getAttribute("classId");

                NodeList nl1 = doc.getElementsByTagName("student");
                System.out.println();
                for (int j = 0; j < nl1.getLength(); j++) {
                    Element IdEle = ((Element) nl1.item(j)); 
                    String sId = IdEle.getAttribute("id");

                    NodeList child = doc.getElementsByTagName("name");
                    Node elementNode = child.item(j);
                   
                    Node textNode = elementNode.getFirstChild();
                    String eValue = textNode.getNodeValue();

                    if (i == 0 && j < nl1.getLength() / 2) {
                        String age = doc.getElementsByTagName("age").item(j).getFirstChild().getNodeValue();
                        String sex = doc.getElementsByTagName("sex").item(j).getFirstChild().getNodeValue();
                        System.out.println("班级：" + attrValue + '\n' + "姓名：" + eValue + '\n' + "学号:" + sId + '\n'
                                + "年龄：" + age + '\n' + "性别：" + sex);
                    }
                    if (i == 1 && j >= nl1.getLength() / 2) {
                        String age = doc.getElementsByTagName("age").item(j).getFirstChild().getNodeValue();
                        String sex = doc.getElementsByTagName("sex").item(j).getFirstChild().getNodeValue();
                        System.out.println("班级：" + attrValue + '\n' + "姓名：" + eValue + '\n' + "学号:" + sId + '\n'
                                + "年龄：" + age + '\n' + "性别：" + sex);
                    }
                }
            }
        } catch (Exception e) {

         
            e.printStackTrace();

        }

    }
}