/**
 * Project Name:test
 * File Name:UDPReceiver.java
 * Package Name:Test4
 * Date:2018年1月10日下午7:56:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package m01.d10.mingxing;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Description:	   <br/>
 * Date:     2018年1月10日 下午7:56:39 <br/>
 * @author   dingP
 * @version  
 * @see 	 
 */
public class UDPReceiver {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6666);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        ds.receive(dp);
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        int length = dp.getLength();
        System.out.println(new String(new String(data,0,length)+"来自于"+ip+"端口号为"+port));
        ds.close();

    }

}

