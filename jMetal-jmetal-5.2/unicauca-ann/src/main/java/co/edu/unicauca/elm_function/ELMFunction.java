package co.edu.unicauca.elm_function;

import java.io.Serializable;

public interface ELMFunction extends Serializable {
	/**
	 * Evaluate x with the function
	 * 
	 * @param x
	 * @return function result
	 */
	double evaluate(double x);
}
