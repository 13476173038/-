/**
 * Project Name:SIXwork
 * File Name:FileServerSocket.java
 * Package Name:m01.d10.luojuan
 * Date:2018年1月10日下午10:19:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午10:19:29 <br/>
 * @author   luojuan
 * @version
 * @see
 */
package m01.d10.luojuan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:04:30 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class FileServerSocket {

    public static void main(String[] args) {
        int port = 10000;
        InputStream ins = null;
        ServerSocket ss = null;
        Socket socket = null;
        FileOutputStream fos = null;
        File file = new File("D:\\myDoc\\text1.txt");
        try {
            ss = new ServerSocket(port);
            socket = ss.accept();
            ins = socket.getInputStream();
            fos = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = ins.read(b)) != -1) {
                fos.write(b, 0, len);
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
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
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
