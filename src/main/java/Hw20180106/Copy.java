/**
 * Project Name:SIXwork
 * File Name:Copy.java
 * Package Name:Hw20180106
 * Date:2018年1月7日下午7:44:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package Hw20180106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;



/**
 * Description:	   <br/>
 * Date:     2018年1月7日 下午7:44:39 <br/>
 * @author   dingP
 * @version  
 * @see 	 
 */
public class Copy {
    private final static Logger LOG = Logger.getLogger(Copy.class);

        public static void main(String[] args) {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try{
                fis = new FileInputStream("C:\\t.zip");
                fos = new FileOutputStream("D:\\t.zip");
                byte[] bytes = new byte[1024];
                int len = 0;
                while((len = fis.read(bytes))!=-1 ){
                    fos.write(bytes,0,len);
                }
            }catch(IOException ex){
                LOG.info(ex);
                throw new RuntimeException("文件复制失败");
            }finally{
                try{
                   if(fos!=null) 
                       fos.close();
                }catch(IOException ex){
                    throw new RuntimeException("释放资源失败");
                    
                }finally{
                    try{
                        if(fis!=null)
                            fis.close();
                    }catch(IOException ex){
                        throw new RuntimeException("释放资源失败");
                    }
                }
                
            }
        }
}

