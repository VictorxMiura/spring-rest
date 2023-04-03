package com.example.demo.mathoperations;

public class Operation {
    public double Soma(Double numberOne, Double numberTwo){
    return numberOne + numberTwo;
    }
    public double Subtração( Double numberOne, Double numberTwo){

        return numberOne - numberTwo;
    }
    public double Divisão( Double numberOne , Double numberTwo){
        return numberOne / numberTwo;
    }


    public double Multiplicação(Double numberOne, Double numberTwo){
     return numberOne *numberTwo;
    }

    public double Media( Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }


    public double raiz(Double number) {
        return Math.sqrt(number);
    }

    }
