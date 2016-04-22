package com.example.andy.test_intent2.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
//先將 Question 加入一些記號標籤(第三方程式庫 會背後完成很多事情)
@Root
public class Question {
    @Element
    private String description;
    @Element
    private String optionA;
    @Element
    private String optionB;
    @Element
    private String optionC;


    public Question(String description, String optionA, String optionB, String optionC) {
        this.description = description;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
    }

    public String getQuestion() {
        return description;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }
}
