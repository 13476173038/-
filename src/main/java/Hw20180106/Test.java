/**
 * Project Name:dt59homework
 * File Name:Test.java
 * Package Name:lesson8
 * Date:2018年1月6日下午4:03:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package Hw20180106;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;



/**
 * Description:	   <br/>
 * Date:     2018年1月6日 下午4:03:23 <br/>
 * @author   mingX
 * @version  
 * @see 	 
 */
public class Test {
    private final static Logger LOG = Logger.getLogger(Test.class);

   
     public static void main(String[] args) throws IOException {

        String path = "C:/lingxing.java";
        path = "D:/lession7homework.java";
        File file = new File(path);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(file);
            byte[] b = new byte[2];
            int len = fis.read(b);
            System.out.println(len+"len等于");
            while(len!=1){
                String str = new String(b,0,len);
                LOG.info("\n"+str);
                len = fis.read(b);
            }
        
        }catch(FileNotFoundException e){
         
            LOG.info("fnff",e);
            
            }catch(IOException e){
                LOG.info("IO",e);
            }finally{
            if(fis!=null){
                fis.close();
            }
            }
        }
}

