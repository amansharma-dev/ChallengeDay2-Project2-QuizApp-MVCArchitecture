package com.example.challengeday2_project2_quizapp_mvcarchitecture.Model;

public class Question {
    private int answerResId;
    private boolean isAnswerTrue;


    public Question(int answerResId, boolean isAnswerTrue) {
        this.answerResId = answerResId;
        this.isAnswerTrue = isAnswerTrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean isAnswerTrue() {
        return isAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        isAnswerTrue = answerTrue;
    }
}
