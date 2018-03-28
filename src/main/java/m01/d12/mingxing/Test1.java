/**
 * Project Name:test
 * File Name:Test.java
 * Package Name:test
 * Date:2018年1月12日上午11:59:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package m01.d12.mingxing;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Description:	   <br/>
 * Date:     2018年1月12日 上午11:59:52 <br/>
 * @author   dingP
 * @version  
 * @see 	 
 */
public class Test1 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File f = new File("C:\\workspace\\lession4\\test\\Test5\\test\\School.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(f);
        NodeList list = doc.getElementsByTagName("student");
        for (int i = 0; i < list.getLength(); i++) {
            NodeList childlist = doc.getElementsByTagName("student");
            Node node = childlist.item(i);
            Node next = node.getFirstChild();
            //NodeList next1 = doc.g();
            //Node node1 = next1.item(i);
            //Node next1 = ;
            String name = next.getNodeValue();
            //String name1 = node1.getNodeValue();
            System.out.println(name);
            //System.out.println(name1);
            //System.out.println();
            
        }
        
        }
        

    }



