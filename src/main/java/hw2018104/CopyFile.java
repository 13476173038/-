package hw2018104;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class CopyFile {

    /**
     * 定义一个方法来实现拷贝文件的功能
     * 
     * @param src 源文件路径
     * @param target 目标文件路径 
     * @throws IOException
     */
	private final static Logger LOG=Logger.getLogger(CopyFile.class);
    public static void CopyFile(File src, File target) throws IOException{
        /**
         * 验证源文件是否存在
         */
        if(!src.exists()){
           LOG.info("There is no such a file !!!");
            System.exit(1);
        }
        /**
         * 验证目标路径是否存在，不存在的话创建父路径
         */
        if(!target.getParentFile().exists()){
            target.getParentFile().mkdirs();
        }

        int temp = 0;   //用作标示是否读取到源文件最后
        InputStream input = new FileInputStream(src);
        OutputStream output = new FileOutputStream(target);

        while((temp = input.read()) != -1){
            output.write(temp);
        }

        input.close();
        output.close();
    }

    public static void main(String[] args) {

        String in = "D:\\qycache\\编辑器\\LESSON1\\src\\homework12.java";//源文件路径
        String out = "D:\\qycache\\编辑器\\LESSON1\\src\\homework12_copy.java";//目标路径(此时还可以重命名)

        File src = new File(in);
        File target = new File(out);

        try {
            CopyFile(src, target);
            LOG.info("Copy Successfully !");
        } catch (IOException e) {
        	LOG.info("ERROR: Something wrong while copying !");
            e.printStackTrace();
        }
    }
}