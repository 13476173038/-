package hw2018104;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

//时间格式输出
public class PublicUtil {
 
  /**
   * 方法说明：取当前日期(格式 20030801)
   * 
   */
  public static String getStrNowDate() {
   java.util.Date tdate = new java.util.Date();
   String nowtime = new Timestamp(tdate.getTime()).toString();
   nowtime = nowtime.substring(0, 10);
   String nowYear = nowtime.substring(0, 4);
   String nowMonth = nowtime.substring(5, 7);
   String nowDay = nowtime.substring(8, 10);
   String nowdate = nowYear + nowMonth + nowDay;
   return nowdate;
  }
  /**
   * 方法说明：取当前日期 (格式 2003-08-01)
   * 
   */
  public static String getNowDate() {
   java.util.Date tdate = new java.util.Date();
   String nowtime = new Timestamp(tdate.getTime()).toString();
   nowtime = nowtime.substring(0, 10);
   return nowtime;
  }
  private final static Logger LOG=Logger.getLogger(PublicUtil.class);
  public static void main(String s[]){
	  LOG.info(getStrNowDate());
	  LOG.info(getNowDate());
   
  }
}