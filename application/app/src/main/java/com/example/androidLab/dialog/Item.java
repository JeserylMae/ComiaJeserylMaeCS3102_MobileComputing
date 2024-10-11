package com.example.androidLab.dialog;

public class Item {
    String calculation;
    String answer;

    public Item (String calculation, String answer) {
        this.calculation = calculation;
        this.answer = answer;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
