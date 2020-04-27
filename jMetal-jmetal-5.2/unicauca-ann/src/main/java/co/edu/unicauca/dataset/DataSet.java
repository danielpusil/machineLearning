package co.edu.unicauca.dataset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.DenseVector;
import no.uib.cipr.matrix.Vector;

/**
 * Collection of data, represent a single statistical data matrix
 */
public class DataSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * -----------------------------------------------------------------------------------------
	 * Atributes
	 * -----------------------------------------------------------------------------------------
	 */
	/**
	 * Path where the file is allocated
	 */
	private String path;
	/**
	 * File name that containts data set File must contain in its firt row:
	 * number-data number-variables number-clases
	 */
	private String fileName;
	/**
	 * Data, every column represents an instance
	 */
	private transient DenseMatrix x;
	/**
	 * Result for i-th column of instance X, it represents the class atribute
	 */
	private DenseVector y;
	/**
	 * Number of posibles results for instances
	 */
	private int numberClasses;
	/**
	 * Index for add a new column
	 */
	private int index;

	/**
	 * -----------------------------------------------------------------------------------------
	 * Methods
	 * -----------------------------------------------------------------------------------------
	 */
	/**
	 * Creates a data set reading it from a file
	 *
	 * @param path         path where file is allocated
	 * @param fileName     File name that containts data set. File must contain in
	 *                     its firt row: number-data number-variables number-clases
	 *                     Every row must be an instance, every colum is a variable
	 *                     and one column is the result from that instance
	 * @param result_index
	 */
	public DataSet(String path, String fileName, int resultIndex) throws IOException {
		this.path = path;
		this.fileName = fileName;
		this.loadInstances(resultIndex);
	}

	/**
	 * Creates a data set given an input data and output data
	 *
	 * @param X input data, every column represents an instance
	 * @param Y output data, every value is the result for i-th column on X
	 */
	public DataSet(DenseMatrix x, DenseVector y) throws Exception {
		if (x.numColumns() != y.size()) {
			throw new Exception(
					"X's number of columns must be the same of Y's size in order they represent a data set ");
		}
		this.x = x;
		this.y = y;
	}

	public DataSet(int numData, int numVariables, int numberClasses) {

		x = new DenseMatrix(numVariables, numData);
		y = new DenseVector(numData);
		index = 0;
		this.numberClasses = numberClasses;
	}

	public void addDataColumn(Vector col) {
		int numData = x.numRows();

		for (int i = 0; i < numData; i++) {
			try {
				x.set(i, index, col.get(i));
			} catch (Exception e) {
				System.out.println("Error insert");
			}
		}
	}

	public void addValueColumn(double value) {
		y.set(index, value);
	}

	public void nextIndex() {
		index++;
	}

	public int getIndex() {
		return index;
	}

	private void loadInstances(int resulIndex) throws IOException {
		BufferedReader br;
		FileReader fr;
		fr = new FileReader(path + "/" + fileName);
		br = new BufferedReader(fr);
		String[] firstRow = br.readLine().split(" ");
		int numRows = Integer.parseInt(firstRow[0]);
		int numCols = Integer.parseInt(firstRow[1]);
		numberClasses = Integer.parseInt(firstRow[2]);

		x = new DenseMatrix(numCols - 1, numRows);
		y = new DenseVector(numRows);
		String actualLine;
		int i = 0;

		while ((actualLine = br.readLine()) != null) {
			String[] aux = actualLine.split(" ");

			for (int j = 0; j < numCols; j++) {
				double value = Double.parseDouble(aux[j]);
				if (j != resulIndex) {
					x.set(j, i, value);
				} else {
					y.set(i, value);
				}
			}
			i++;
		}
	}

	public DenseMatrix getX() {
		return x;
	}

	public DenseVector getY() {
		return y;
	}

	public int getNumberClasses() {
		return numberClasses;
	}

}
