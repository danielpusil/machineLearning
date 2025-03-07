package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.ELM;
import co.edu.unicauca.elm.function.ELMFunction;
import co.edu.unicauca.elm.util.ELMUtil;
import co.edu.unicauca.moorepenrose.AbstractMoorePenroseMethod;

import java.util.ArrayList;
import java.util.List;
import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.DenseVector;
import no.uib.cipr.matrix.Matrices;
import no.uib.cipr.matrix.Vector;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import org.uma.jmetal.solution.DoubleSolution;

/**
 * Elm's Evaluator using cross validation files
 */
public abstract class AbstractCrossValidationEvaluator extends AbstractELMEvaluator {

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
	 * Number of folders
	 */
	private int numberFolders;
	/**
	 * Data sets for training ELM
	 */
	private List<DataSet> trainingFolders;
	/**
	 * Data sets for testing ELM
	 */
	private List<DataSet> testingFolders;

	/**
	 * -----------------------------------------------------------------------------------------
	 * Methods
	 * -----------------------------------------------------------------------------------------
	 */
	/**
	 * Creates a cross validation evaluator
	 *
	 * @param type
	 * @param name
	 * @param trainingDataSet
	 * @param testingdataSet
	 * @param numberFolders
	 * @param hiddenNeurons
	 * @param activationFunction
	 * @param inverse
	 * @param maxEvaluations     Maximun number of evaluations for objective
	 *                           function
	 */
	public AbstractCrossValidationEvaluator(EvaluatorType type, String name, DataSet trainingDataSet,
			DataSet testingdataSet, int numberFolders, int hiddenNeurons, ELMFunction activationFunction,
			AbstractMoorePenroseMethod inverse, int maxEvaluations) {

		super(type, name, trainingDataSet, testingdataSet);
		this.numberFolders = numberFolders;
		super.elm = new ELM(ELMUtil.getELMType(trainingDataSet), hiddenNeurons, activationFunction,
				trainingDataSet.getNumberClasses(), inverse);
		int inputNeuron = trainingDataSet.getX().numRows();
		super.elm.setInputNeurons(inputNeuron);
		makeFolders();
		super.loadInitalConfiguration();
	}

	private void makeFolders() {
		trainingFolders = new ArrayList<>();
		testingFolders = new ArrayList<>();
		int trainigSize = super.trainingDataSet.getX().numColumns();
		int numberVariables = trainingDataSet.getX().numRows();
		int numberData = trainingDataSet.getX().numColumns();
		int numberClases = trainingDataSet.getNumberClasses();
		DenseMatrix x = trainingDataSet.getX();
		DenseVector y = trainingDataSet.getY();
		int aditionals = numberData % numberFolders;
		int sizeFolder = numberData / numberFolders;

		for (int i = 0; i < numberFolders; i++) {
			if (i < aditionals) {
				trainingFolders.add(new DataSet((sizeFolder * (numberFolders - 1)) + (aditionals - 1), numberVariables,
						numberClases));
				testingFolders.add(new DataSet(sizeFolder + 1, numberVariables, numberClases));
			} else {
				trainingFolders.add(
						new DataSet((sizeFolder * (numberFolders - 1)) + aditionals, numberVariables, numberClases));
				testingFolders.add(new DataSet(sizeFolder, numberVariables, numberClases));
			}
		}

		for (int i = 0; i < trainigSize; i++) {
			Vector data = Matrices.getColumn(x, i);
			double value = y.get(i);
			int result = i % numberFolders;
			for (int j = 0; j < numberFolders; j++) {

				if (result != j) {
					DataSet training = trainingFolders.get(j);
					training.addDataColumn(data);
					training.addValueColumn(value);
					training.nextIndex();
				} else {
					DataSet testing = testingFolders.get(j);
					testing.addDataColumn(data);
					testing.addValueColumn(value);
					testing.nextIndex();
				}

			}
		}

	}

	@Override
	public double train() {
		double accuracy = 0.0;
		for (int i = 0; i < numberFolders; i++) {
			DataSet training = trainingFolders.get(i);
			DataSet testing = testingFolders.get(i);
			elm.setX(training.getX());
			elm.setY(training.getY());
			elm.train();
			elm.setX(testing.getX());
			elm.setY(testing.getY());
			elm.test();
			accuracy += elm.getAccuracy();
		}

		return accuracy / numberFolders;
	}

	@Override
	public double test(DoubleSolution solution) {
		super.getInputWeightsBiasFrom(solution);
		elm.setInputWeight(inputWeights);
		elm.setBiasHiddenNeurons(bias);
		elm.setX(trainingDataSet.getX());
		elm.setY(trainingDataSet.getY());
		elm.train();
		elm.setX(testingDataSet.getX());
		elm.setY(testingDataSet.getY());
		elm.test();
		return elm.getAccuracy();
	}
}
