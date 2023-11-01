package com.denizdogan.calculator;

public class CalculatorProcessHolder {


    private static CalculatorProcessHolder instance = null;

    private double item1;
    private char whichOperation;
    private double item2;

    private CalculatorProcessHolder() {

    }

    public static CalculatorProcessHolder getInstance(){

        if(instance == null){
            instance = new CalculatorProcessHolder();
        }
        return instance;
    }

    public double getItem1() {
        return item1;
    }

    public void setItem1(double item1) {
        this.item1 = item1;
    }

    public char getWhichOperation() {
        return whichOperation;
    }

    public void setWhichOperation(char whichOperation) {
        this.whichOperation = whichOperation;
    }

    public double getItem2() {
        return item2;
    }

    public void setItem2(double item2) {
        this.item2 = item2;
    }

    public double getResultForDouble(){
        double result = 0;
        switch (whichOperation){
            case '+':
                result = item1 + item2;
                break;
            case '-':
                result = item1 - item2;
                break;
            case 'x':
                result = item1 * item2;
                break;
            case '/':
                result = item1 / item2;
                break;
        }
        return result;
    }
}
