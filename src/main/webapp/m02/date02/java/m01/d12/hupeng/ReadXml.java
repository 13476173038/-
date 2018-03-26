package m01.d12.hupeng;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Project Name:LianXiDemo
 * File Name:ReadXml.java
 * Package Name:
 * Date:2018年1月12日下午4:38:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description:   <br/>
 * Date:     2018年1月12日 下午4:38:24 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class ReadXml {
    public static void main (String[]args){
        
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();

        try{
          DocumentBuilder db = dbf.newDocumentBuilder();
          
          Document doc = db.parse("src\\cn\\zuoye\\xml\\Class.xml");
         
          NodeList userList = doc.getElementsByTagName("user");
         
          System.out.println("共有 "+userList.getLength()+" 个user节点");

          for(int i = 0; i < userList.getLength(); i ++){
            Node user = userList.item(i);  
            Element elem = (Element) user;
           
            System.out.println("id:" + elem.getAttribute("id"));  
            for(Node node = user.getFirstChild();node != null; node = node.getNextSibling()){
              if (node.getNodeType() == Node.ELEMENT_NODE)  
              {  
                  String name = node.getNodeName();  
                  String value = node.getFirstChild().getNodeValue();  
                  System.out.print(name + ":" + value + "\t");  
              }
              System.out.println();
            }
          }
        
      }catch(Exception e){
    	  e.printStackTrace();
      }
}
}



