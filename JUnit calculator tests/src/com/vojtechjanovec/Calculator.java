package com.vojtechjanovec;

public class Calculator {
    private double firstNum;
    private double secNum;

    public Calculator(double firstNum, double secNum) {
        this.firstNum = firstNum;
        this.secNum = secNum;
    }

    public double addition() {
        return this.firstNum+this.secNum;
    }

    public double subtraction() {
        return this.firstNum-this.secNum;
    }

    public double multiplication() {
        return this.firstNum*this.secNum;
    }

    public double division() {
        return this.firstNum/this.secNum;
    }
    public double maximum() {
        if(this.firstNum > secNum) {
            return firstNum;
        } else {
            return secNum;
        }
    }
    public double minimum() {
        if(this.firstNum < secNum) {
            return firstNum;
        } else {
            return secNum;
        }
    }
    public double percentage() {
        return this.firstNum*(this.secNum/100);
    }
    public double power() {
        return Math.pow(firstNum, secNum);
    }
}
