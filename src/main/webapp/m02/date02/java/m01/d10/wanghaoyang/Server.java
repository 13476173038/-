/**
 * Project Name:SIXwork
 * File Name:Server.java
 * Package Name:m01.d10.WangHaoYang
 * Date:2018年1月10日下午7:59:26
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wanghaoyang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:59:26 <br/>
 * 
 * @author WangHaoyang
 * @version
 * @see
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 1.创建服务端
        ServerSocket ss = new ServerSocket(10000);
        // 接收客户端
        Socket socket = null;

        // 2.获取输出流，向文件中写入内容
        File f = new File("d:/newIn.txt");
        FileOutputStream out = new FileOutputStream(f);
        String str = null;
        // byte buffs[] = new byte[1024];
        // int length = 0;

        // 3.获取输入流
        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String nextLine = System.getProperty("line.separator");
        while (true) {
            socket = ss.accept();
            in = socket.getInputStream();
            isr = new InputStreamReader(in);
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                System.out.println("接收到的数据：" + str);
                out.write((str + nextLine).getBytes());
                out.flush();
            }
            out.close();
            System.exit(0);
        }

    }
}
