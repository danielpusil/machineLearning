package co.edu.unicauca.elm.function.impl;

import co.edu.unicauca.elm.function.ELMFunction;


public class Sigmoid implements ELMFunction
{
    @Override
    public double evaluate(double x) 
    {
        double exp = Math.exp(-x) + 1;
        return 1 / exp;        
    }
}