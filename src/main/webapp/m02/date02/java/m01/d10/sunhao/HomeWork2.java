/**
 * Project Name:SIXwork
 * File Name:HomeWork2.java
 * Package Name:m01.d10.sunhao
 * Date:2018年1月10日下午9:56:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.sunhao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午9:56:51 <br/>
 * 
 * @author sunhao
 * @version
 * @see
 */
public class HomeWork2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1.创建socket，连接到服务端
        Socket socket = new Socket("localhost", 10000);

        // 2.获取输出流，向服务端发送信息
        // 字节输出流
        java.io.OutputStream os = socket.getOutputStream();
        // 将输出流包装成打印流
        PrintWriter pw = new PrintWriter(os);

        // 3.获取输入流，读取文件中的信息
        // 文件输入流
        InputStream in = new FileInputStream("d://workspace");
        InputStreamReader isr = new InputStreamReader(in, "wrork");
        BufferedReader br = new BufferedReader(isr);
        String str = null;

        while ((str = br.readLine()) != null) {
            System.out.println("文件读取内容为： " + str);
            pw.write(str + "\r\n");
            pw.flush();
            Thread.sleep(1000);
        }

        pw.close();
        br.close();
        in.close();
        os.close();
    }

}
