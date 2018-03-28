/**
 * Project Name:SIXwork
 * File Name:QuestionInfo.java
 * Package Name:m03.d28.luojuan.eneity
 * Date:2018年3月28日下午7:19:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.luojuan.eneity;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午7:19:56 <br/>
 * 
 * @author luojuan
 * @version
 * @see
 */
public class QuestionInfo {

    private int QuestionId;

    private String Question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private int subject;

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
