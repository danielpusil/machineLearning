package co.edu.unicauca.factory.algorithm;

import co.edu.unicauca.factory.parameters.AbstractParametersFactory;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import org.uma.jmetal.algorithm.singleobjective.solis_and_wets.SolisAndWetsBuilder;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.util.AlgorithmBuilder;
import org.uma.jmetal.util.JMetalException;

/**
 * Factory to Solis and Wets algorithms builders, with configuration needed for
 * elm problem.
 */
public class SolisAndWetsFactory extends AbstractBuilderFactory {
	private static final String SOLIS_AND_WETS = "SolisAndWets";
	private double rHO;
	private int neighborHood;

	public SolisAndWetsFactory(AbstractParametersFactory parametersFactory) {
		super(parametersFactory);
	}

	@Override
	public AlgorithmBuilder<?> getAlgorithm(String name, AbstractELMEvaluator.EvaluatorType evaluatorType,
			DoubleProblem problem) throws Exception {
		int evaluations = evaluatorType == AbstractELMEvaluator.EvaluatorType.TT ? EVALUATIONS_TT : EVALUATIONS_CV;
		AlgorithmBuilder<?> builder = null;
		this.loadAlgorithmValues(name, evaluatorType);
		if (name.equals(SOLIS_AND_WETS)) {
			builder = this.getSolisAndWets(evaluations, problem);
		} else {
			throw new JMetalException("Algorithm " + name + " not exists");
		}
		return builder;
	}

	private AlgorithmBuilder<?> getSolisAndWets(int evaluations, DoubleProblem problem) {
		return new SolisAndWetsBuilder(problem).setRho(rHO).setSizeNeighborhood(neighborHood)
				.setPenalizeValue(PENALIZE_VALUE).setMaxEvaluations(evaluations).setComparator(COMPARATOR);
	}

	@Override
	protected void loadAlgorithmValues(String name, AbstractELMEvaluator.EvaluatorType evaluatorType) throws Exception {
		rHO = parametersFactory.getValue("RHO", evaluatorType, SOLIS_AND_WETS);
		neighborHood = (int) parametersFactory.getValue("SIZENEIGH", evaluatorType, SOLIS_AND_WETS);

	}

}
