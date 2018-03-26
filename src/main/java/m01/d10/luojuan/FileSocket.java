/**
 * Project Name:SIXwork
 * File Name:FileSocket.java
 * Package Name:m01.d10.luo
 * Date:2018年1月10日下午10:18:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.luojuan;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午10:18:24 <br/>
 * @author   luojuan
 * @version
 * @see
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileSocket {
    public static void main(String[] args) {

        Socket socket = null;
        OutputStream ous = null;
        FileInputStream fis = null;
        InputStream ins = null;
        File file = new File("D:\\myDoc\\text.txt");
        InetAddress address;
        int port = 10000;
        String host = "127.0.0.1";
        try {
            address = InetAddress.getByName(host);
            try {
                socket = new Socket(address, port);
                ous = socket.getOutputStream();
                fis = new FileInputStream(file);
                byte[] b = new byte[1024];// 创建一个空间为1024个字节的数组b
                int len = fis.read(b);// 从原文件中读取b个字节给len
                while (len != -1) {// read()方法的返回值为-1，文件读完
                    ous.write(b, 0, len);// 将b数组中的第一个字符开始到最后一个写入该文件
                    ous.flush();
                    len = fis.read(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            if (ous != null) {
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
