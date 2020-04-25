package co.edu.unicauca.moore.penrose.impl;

import co.edu.unicauca.moore.penrose.AbstractMoorePenroseMethod;
import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.Matrices;

/**
 * A+ = A∗(AA∗)−1 Where A* A's transpose and A+ pseudoinverse of A
 */
public class MultiplicationMethod extends AbstractMoorePenroseMethod {

    /**
     * -----------------------------------------------------------------------------------------
     * Methods
     * -----------------------------------------------------------------------------------------
     */
    /**
     * @param values
     */
    public MultiplicationMethod(double[] values) {
        super(values);
    }

    /**
     * MP(A) = ((A'A)^-1)A'
     *
     * @param aMatrix matrix
     * @return pseudoinverse moore penrose of A
     */
    public DenseMatrix calculate(DenseMatrix aMatrix) {

        int n = aMatrix.numRows();
        int m = aMatrix.numColumns();
        //A*
        DenseMatrix transpose = new DenseMatrix(m, n);
        aMatrix.transpose(transpose);

        //A*A
        DenseMatrix aMatrixTransposeA = new DenseMatrix(m, m);
        transpose.mult(aMatrix, aMatrixTransposeA);

        //(AA∗)−1
        DenseMatrix iMatrix = Matrices.identity(m);
        DenseMatrix inv = iMatrix.copy();
        aMatrixTransposeA.solve(iMatrix, inv);
        //A∗(AA∗)−1
        DenseMatrix moorePenrose = new DenseMatrix(m, n);
        inv.mult(transpose, moorePenrose);
        return moorePenrose;
    }

}
