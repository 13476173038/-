import java.util.Scanner;

/**
 * Project Name:JDBC_Dao
 * File Name:Main.java
 * Package Name:
 * Date:2018年3月28日下午3:13:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:13:48 <br/>
 * @author   hupeng
 * @version
 * @see
 */
public class Main {

	public static  void main(String[] args) {
		QuestionInfoDaoImpl qid=new QuestionInfoDaoImpl();
		Scanner sc =new Scanner(System.in);
		System.out.println("****************欢迎使用试题管理系统****************");
		System.out.println("请选择操作(1.列出所有试题信息2.按科目查询"
				+ "3.按题干模糊查询4.添加试题5.删除试题6.退出系统)");
		int key =sc.nextInt();
		switch (key) {
			case 1 :
				qid.getAll();
				break;
			case 2 :
				qid.selectsubject();
				break;
			case 3 :
				qid.select_t(null);
				break;
			case 4 :
				qid.insert();
				break;
			case 5 :
				 boolean flage= false;  
		            do{  
		                System.out.println("请输入需要删除的试题编号");  
		                int choose = sc.nextInt();  
		                flage = qid.delete(choose);  
		            }while(!flage);  
		              
		            break;  
			case 6 :
				qid.selectQuestionId();
				break;			
			default :
				break;
		}
	}
	

	

	


}

