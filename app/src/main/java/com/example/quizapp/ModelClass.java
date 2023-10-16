package com.example.quizapp;

public class ModelClass {
    String questions,oA,oB,oC,oD,ans;

    public ModelClass(String questions, String oA, String oB, String oC, String oD, String ans) {
        this.questions = questions;
        this.oA = oA;
        this.oB = oB;
        this.oC = oC;
        this.oD = oD;
        this.ans = ans;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public void setoC(String oC) {
        this.oC = oC;
    }

    public void setoD(String oD) {
        this.oD = oD;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getQuestions() {
        return questions;
    }

    public String getoA() {
        return oA;
    }

    public String getoB() {
        return oB;
    }

    public String getoC() {
        return oC;
    }

    public String getoD() {
        return oD;
    }

    public String getAns() {
        return ans;
    }
}
