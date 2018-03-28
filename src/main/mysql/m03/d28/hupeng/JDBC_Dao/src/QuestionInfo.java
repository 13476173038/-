/**
 * Project Name:JDBC_Dao
 * File Name:QuestionInfo.java
 * Package Name:
 * Date:2018年3月28日下午3:07:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午3:07:02 <br/>
 * @author   hupeng
 * @version
 * @see
 */
//试题信息实体类
public class QuestionInfo {
	//试题编号
	private int QuestionId;
	//题干
	private String Question;
	//选项A
	private String optionA;
	//选项B
	private String optionB;
	//选项C 
	private String optionC;
	//选项D
	private String optionD;
	//科目
	private int subject;
	//正确答案
	private String answer;
	
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public int getSubject() {
		return subject;
	}
	public void setSubject(int subject) {
		this.subject = subject;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
   
}

