package co.edu.unicauca.problem.training_testing;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.ELM;
import co.edu.unicauca.elm.util.ELMUtil;
import co.edu.unicauca.elm_function.ELMFunction;
import co.edu.unicauca.moore_penrose.AbstractMoorePenroseMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import org.uma.jmetal.solution.DoubleSolution;

/**
 * Elm's Evaluator using training and testing files
 */
public abstract class TrainingTestingEvaluator extends AbstractELMEvaluator {

	/**
	 * -----------------------------------------------------------------------------------------
	 * Atributes
	 * -----------------------------------------------------------------------------------------
	 */

	/**
	 * -----------------------------------------------------------------------------------------
	 * Methods
	 * -----------------------------------------------------------------------------------------
	 */
	/**
	 * Creates a trainig testing evaluator
	 *
	 * @param hiddenNeurons      number of hidden neurons in the ELM
	 * @param trainingDataSet   collection of data for training
	 * @param testingDataSet    collection of data for testing
	 * @param activationFunction activation function use in ELM
	 * @param inverse             Method for calculating Moore Penrose v
	 * @param name                Evaluator's name
	 * @param maxEvaluations      Maximun number of evaluations for objective
	 *                            function
	 */
	public TrainingTestingEvaluator(int hiddenNeurons, DataSet trainingDataSet, DataSet testingDataSet,
			ELMFunction activationFunction, AbstractMoorePenroseMethod inverse, String name, int maxEvaluations) {
		super(AbstractELMEvaluator.EvaluatorType.TT, name, trainingDataSet, testingDataSet);
		super.elm = new ELM(ELMUtil.getELMType(trainingDataSet), hiddenNeurons, activationFunction,
				trainingDataSet.getNumberClasses(), inverse);
		this.elm.setX(trainingDataSet.getX());
		this.elm.setY(trainingDataSet.getY());
		super.loadInitalConfiguration();
	}

	@Override
	public double train() {
		super.elm.train();
		return elm.getAccuracy();
	}

	@Override
	public double test(DoubleSolution solution) {
		super.getInputWeightsBiasFrom(solution);
		elm.setInputWeight(inputWeights);
		elm.setBiasHiddenNeurons(bias);
		elm.train();
		elm.setX(testingDataSet.getX());
		elm.setY(testingDataSet.getY());
		elm.test();
		this.elm.setX(trainingDataSet.getX());
		this.elm.setY(trainingDataSet.getY());
		return elm.getAccuracy();
	}

}
