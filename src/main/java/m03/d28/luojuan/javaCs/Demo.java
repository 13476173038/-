/**
 * Project Name:SIXwork
 * File Name:Main.java
 * Package Name:m03.d28.luojuan.javaCs
 * Date:2018年3月28日下午7:21:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.luojuan.javaCs;

import java.util.List;
import java.util.Scanner;

import m03.d28.luojuan.dao.QuestionInfoDao;
import m03.d28.luojuan.dao.impl.QuestionInfoDaoImpl;
import m03.d28.luojuan.eneity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午7:21:12 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class Demo {

    public static void main(String[] args) {
        QuestionInfoDao qInfoDao = new QuestionInfoDaoImpl();
        System.out.println("==================欢迎使用试题管理系统==================");
        System.out.println("请选择操作（1.列出所有试题   2.按科目查询    3.按题干模糊查询    4.添加试题    5.删除试题    6.退出系统）");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        switch (result) {
        case 1: {
            List<QuestionInfo> list = qInfoDao.getAllInfo();
            for (QuestionInfo ff : list) {
                System.out.println(ff.getQuestionId() + "." + ff.getQuestion() + "\n" + ff.getOptionA() + "\t"
                        + ff.getOptionB() + "\t" + ff.getOptionC() + "\t" + ff.getOptionD() + "\t" + ff.getSubject()
                        + "\n" + ff.getAnswer());
            }

            break;
        }

        case 2: {
            QuestionInfo info = new QuestionInfo();
            System.out.println("请输入要查询的课程编号");
            info.setSubject(sc.nextInt());
            int flag = qInfoDao.selectSub(info);
            if (flag > 0) {
                System.out.println("ok");
            } else {
                System.out.println("xx");
            }
            // List<QuestionInfo> list2 = qInfoDao.getAllInfo();
            // for (QuestionInfo qq : list2) {
            // System.out.println(qq.getQuestionId() + "." + qq.getQuestion() +
            // "\n" + qq.getOptionA() + "\t"
            // + qq.getOptionB() + "\t" + qq.getOptionC() + "\t" +
            // qq.getOptionD() + "\t" + qq.getSubject()
            // + "\n" + qq.getAnswer());
            // }
            break;
        }
        case 3: {
            System.out.println("请输入要删除的编号:");
            int id = sc.nextInt();
            int flag = qInfoDao.deleteSt(id);
            System.out.println("删除的结果：" + flag);
            System.out.println("=====================结果是：======================");
            List<QuestionInfo> list2 = qInfoDao.getAllInfo();
            for (QuestionInfo ff : list2) {
                System.out.println(ff.getQuestionId() + "." + ff.getQuestion() + "\n" + ff.getOptionA() + "\t"
                        + ff.getOptionB() + "\t" + ff.getOptionC() + "\t" + ff.getOptionD() + "\t" + ff.getSubject()
                        + "\n" + ff.getAnswer());
            }
        }
        default:
            break;
        }
    }
}
