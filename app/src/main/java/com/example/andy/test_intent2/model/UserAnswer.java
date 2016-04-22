package com.example.andy.test_intent2.model;


public class UserAnswer {
    private int indextArray;
    private CharSequence[] answer;
    private CharSequence[] description;


    public UserAnswer(int indextArray) {
        this.indextArray = indextArray;
        newArray();
    }



    public void newArray() {
        answer = new CharSequence[indextArray];
        description = new String[indextArray];

    }


    public void setAnswer(int index , CharSequence 答案,CharSequence 描述){

        answer[index]=答案;
        description[index]=描述;


    }
    public CharSequence getAnswer(int indext) {

        return answer[indext];
    }

    public CharSequence getDescription(int indext) {

        return description[indext];
    }





}
