/**
 * Project Name:test
 * File Name:paixu.java
 * Package Name:test
 * Date:2018年1月4日下午2:40:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package Hw20180106;

import java.util.Scanner;

/**
 * Description:	   <br/>
 * Date:     2018年1月4日 下午2:40:58 <br/>
 * @author   dingP
 * @version  
 * @see 	 
 */
public class paixu {

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组大小");
        int a = scanner.nextInt();
        int[] atts = new int[a];
        for (int i = 0; i < atts.length; i++) {
            System.out.println("请输入数组内的数值");
            int b = scanner.nextInt();
            atts[i]=b;
        }
        for (int i = 0; i < atts.length; i++) {
             System.out.println(atts[i]);
        }
       scanner.close();
       String c = new String();
  System.out.println(c);

    }

}

