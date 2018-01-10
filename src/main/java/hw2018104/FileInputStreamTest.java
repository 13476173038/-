package hw2018104;
//import hw2018104.class3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;

import org.apache.log4j.Logger;


public class FileInputStreamTest {
	private final static Logger LOG=Logger.getLogger(FileInputStreamTest.class);
	public FileInputStreamTest(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=null;
          try{
          fis=new FileInputStream("D:\\qycache\\编辑器\\LESSON1\\src\\homework12.java");
          int data;
          LOG.info("可读取的字节数"+ fis.available());
          LOG.info("文件的内容为");
          while((data= fis.read())!=-1){
        	  LOG.info((char)data+" ");
          }
          }catch (FileNotFoundException e){
        	  e.printStackTrace();
          }catch (IOException e){
        	  e.printStackTrace();
          }finally{
        	  try{
        		  if(fis!=null)
        		       fis.close();
        		  
        	  }catch (IOException e){
        		  e.printStackTrace();
          }
          
          
	}

}
}