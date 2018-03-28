/**
 * Project Name:Lesson3
 * File Name:xmlSchool.java
 * Package Name:less0112
 * Date:2018年1月12日下午2:06:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d12.luojuan;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Description: <br/>
 * Date: 2018年1月12日 下午2:06:45 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class xmlSchool {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();// 从XML文档获取生成DOM对象树的解析器
            DocumentBuilder db = dbf.newDocumentBuilder();// 使其从XML文档中获取DOM文档实例
            File file = new File("D:\\myDoc\\School.xml");  //.xml文件的路径是之前用editplus写时存放的路径
            Document doc = db.parse(file);// 将给定文件的内容解析为一个 XML 文档

            NodeList classList = doc.getElementsByTagName("class");// 得到所有class节点列表信息
            for (int i = 0; i < classList.getLength(); i++) { // 循环class信息
                Node classNode = classList.item(i); // 获取第i个class元素信息

                Element ele = (Element) classNode; // 获取第i个class元素的classId属性的值
                String attrValue = ele.getAttribute("classId");

                NodeList nl1 = ele.getElementsByTagName("student");// 得到所有student节点列表信息
                System.out.println();// 换行
                for (int j = 0; j < nl1.getLength(); j++) {
                    Element IdEle = ((Element) nl1.item(j)); // 找到第j个student节点
                    String sId = IdEle.getAttribute("id"); // 获得id

                    NodeList child = doc.getElementsByTagName("name");// 得到所有name节点列表信息
                    Node elementNode = child.item(j);// 获取第j个name元素信息
                    // String eValue = elementNode.getNodeValue();
                    Node textNode = elementNode.getFirstChild();// 返回第一个子节点
                    String eValue = textNode.getNodeValue();// 返回节点的值

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

            // Auto-generated catch block
            e.printStackTrace();

        }

    }
}
