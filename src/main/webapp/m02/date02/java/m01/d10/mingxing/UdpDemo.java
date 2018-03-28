/**
 * Project Name:test
 * File Name:UdpDemo.java
 * Package Name:Test4
 * Date:2018年1月10日下午7:21:40
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package m01.d10.mingxing;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Description:	   <br/>
 * Date:     2018年1月10日 下午7:21:40 <br/>
 * @author   dingP
 * @version  
 * @see 	 
 */
public class UdpDemo {
    public static void main(String[] args) throws IOException {
        byte[] data = "明星真帅".getBytes();
        InetAddress inet = InetAddress.getByName("192.168.80.149");
        DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6666);
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
        ds.close();
        
    }
}

