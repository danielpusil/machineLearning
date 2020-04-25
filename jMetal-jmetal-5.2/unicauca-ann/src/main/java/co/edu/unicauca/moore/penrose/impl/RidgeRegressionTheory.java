package co.edu.unicauca.moore.penrose.impl;

import co.edu.unicauca.moore.penrose.AbstractMoorePenroseMethod;
import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.Matrices;

public class RidgeRegressionTheory extends AbstractMoorePenroseMethod {

	/**
	 * -----------------------------------------------------------------------------------------
	 * Methods
	 * -----------------------------------------------------------------------------------------
	 */
	public RidgeRegressionTheory(double[] values) {
		super(values);
	}

	@Override
	public DenseMatrix calculate(DenseMatrix aMatrix) {
		/*
		 * Moore-Penrose generalized inverse maxtrix Theory:Ridge regression MP(A) =
		 * inv((H'*H+lumda*I))*H'
		 */

		if (values == null || values.length == 0) {
			throw new UnsupportedOperationException("Values must contain lumda value in its first position.");
		}
		double lumda = values[0];
		int n = aMatrix.numColumns();
		int m = aMatrix.numRows();

		DenseMatrix aMatrizt = new DenseMatrix(n, m);
		aMatrix.transpose(aMatrizt);
		DenseMatrix aMatrixtA = new DenseMatrix(n, n);
		aMatrizt.mult(aMatrix, aMatrixtA);

		DenseMatrix iMatrix = Matrices.identity(n);
		aMatrixtA.add(lumda, iMatrix);
		DenseMatrix aMatrixtAinv = iMatrix.copy();
		aMatrixtA.solve(iMatrix, aMatrixtAinv);
		DenseMatrix Ainv = new DenseMatrix(n, m);
		aMatrixtAinv.mult(aMatrizt, Ainv);
		return Ainv;
	}

}
