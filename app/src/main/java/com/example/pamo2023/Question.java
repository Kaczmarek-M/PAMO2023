package com.example.pamo2023;

public class Question {

    private int ansID;
    private boolean ans;

    public Question(int ansID, boolean ans) {
        this.ansID = ansID;
        this.ans = ans;
    }

    public int getAnsID() {
        return ansID;
    }

    public void setAnsID(int ansID) {
        this.ansID = ansID;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
