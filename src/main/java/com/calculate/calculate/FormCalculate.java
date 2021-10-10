package com.calculate.calculate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class FormCalculate {
    @NotNull
    @Size(min = 3)
    private String expression;
    private double result;

    public FormCalculate() {
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public List<String> getList(String str){
        List<String> list = new ArrayList<>();
        char [] ch=str.toCharArray();

        for(char c:ch){
            list.add(String.valueOf(c));
        }

        return list;
    }
}
