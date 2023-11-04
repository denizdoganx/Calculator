package com.denizdogan.calculator;

public class CalculatorProcessHolder {


    private static CalculatorProcessHolder instance = null;

    private double item1;
    private char whichOperation;
    private double item2;

    private int intItem1;

    private int intItem2;

    public int getIntItem1() {
        return intItem1;
    }

    public void setIntItem1(int intItem1) {
        this.intItem1 = intItem1;
    }

    public int getIntItem2() {
        return intItem2;
    }

    public void setIntItem2(int intItem2) {
        this.intItem2 = intItem2;
    }

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

    public String getResult(){
        double result = 0;
        String stringFormatOfResult;
        boolean areTheyAllZero = true, pointFound = false;
        String pieceOfBeforePoint = "";
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
        stringFormatOfResult = String.valueOf(result);

        for(int i = 0;i < stringFormatOfResult.length(); i++){

            if(!pointFound){
                if(stringFormatOfResult.charAt(i) == '.'){
                    pointFound = true;
                    continue;
                }
                else {
                    pieceOfBeforePoint += stringFormatOfResult.charAt(i);
                }
            }

            if(pointFound && stringFormatOfResult.charAt(i) != '0'){
                areTheyAllZero = false;
            }
        }

        if(areTheyAllZero){
            return pieceOfBeforePoint;
        }
        else{
            return stringFormatOfResult;
        }
    }


}
