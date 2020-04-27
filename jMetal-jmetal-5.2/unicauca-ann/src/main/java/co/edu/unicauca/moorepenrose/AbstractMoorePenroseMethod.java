package co.edu.unicauca.moorepenrose;

import java.io.Serializable;

import no.uib.cipr.matrix.DenseMatrix;

/**
 * Method for calculating pseudoinverse mooore penrose
 */
public abstract class AbstractMoorePenroseMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ----------------------------------------------------------------------------------------
	 * Atributes
	 * -----------------------------------------------------------------------------------------
	 */
	/**
	 * Values needed for pseudoinverse calculation
	 */
	protected double[] values;

	/**
	 * ----------------------------------------------------------------------------------------
	 * Methods
	 * -----------------------------------------------------------------------------------------
	 */
	public AbstractMoorePenroseMethod(double[] values) {
		this.values = values;
	}

	/**
	 * Calculate Moore-Penrose Pseudoinverse
	 *
	 * @param A matrix to calculate moore-penrose pseudoinverse
	 * @return A's pseudoinverse
	 */
	public abstract DenseMatrix calculate(DenseMatrix A) throws Exception;

	public double[] getValues() {
		return values;
	}

	public void setValues(double[] values) {
		this.values = values;
	}
}
