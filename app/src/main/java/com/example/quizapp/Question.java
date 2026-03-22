package com.example.quizapp;

public class Question {
    private String mQuestion;
    private String mOption1;
    private String mOption2;
    private String mOption3;
    private String mOption4;
    private int mAnswerIndex; // Should be 1, 2, 3, or 4

    public Question(String question, String option1, String option2, String option3, String option4, int answerIndex) {
        mQuestion = question;
        mOption1 = option1;
        mOption2 = option2;
        mOption3 = option3;
        mOption4 = option4;
        mAnswerIndex = answerIndex;
    }

    public String getQuestion() { return mQuestion; }
    public String getOption1() { return mOption1; }
    public String getOption2() { return mOption2; }
    public String getOption3() { return mOption3; }
    public String getOption4() { return mOption4; }
    public int getAnswerIndex() { return mAnswerIndex; }
}
