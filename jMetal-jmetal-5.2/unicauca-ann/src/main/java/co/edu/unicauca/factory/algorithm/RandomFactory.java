package co.edu.unicauca.factory.algorithm;

import java.util.Comparator;

import org.uma.jmetal.algorithm.singleobjective.random_search.RandomSearchBuilder;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.util.AlgorithmBuilder;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.comparator.ObjectiveComparator;

import co.edu.unicauca.factory.parameters.AbstractParametersFactory;
import co.edu.unicauca.problem.AbstractELMEvaluator;

/**
 * Factory to Random algorithms builders, with configuration needed for elm
 * problem.
 */
public class RandomFactory extends AbstractBuilderFactory {
	private static final String RANDOM = "Random";
	private static final Comparator<DoubleSolution> COMPARATOR_RANDOM = new ObjectiveComparator<>(0,
			ObjectiveComparator.Ordering.DESCENDING);

	public RandomFactory(AbstractParametersFactory parametersFactory) {
		super(parametersFactory);
	}

	@Override
	public AlgorithmBuilder<?> getAlgorithm(String name, AbstractELMEvaluator.EvaluatorType evaluatorType,
			DoubleProblem problem) throws Exception {
		int evaluations = evaluatorType == AbstractELMEvaluator.EvaluatorType.TT ? EVALUATIONS_TT : EVALUATIONS_CV;
		AlgorithmBuilder<?> builder = null;
		this.loadAlgorithmValues(name, evaluatorType);
		if (name.equals(RANDOM)) {
			builder = this.getRandom(evaluations, problem);
		} else {
			throw new JMetalException("Algorithm " + name + " not exists");
		}
		return builder;
	}

	private AlgorithmBuilder<?> getRandom(int evaluations, DoubleProblem problem) {
		return new RandomSearchBuilder(problem).setMaxEvaluations(evaluations).setComparator(COMPARATOR_RANDOM)
				.setPenalizeValue(PENALIZE_VALUE);
	}

	@Override
	protected void loadAlgorithmValues(String name, AbstractELMEvaluator.EvaluatorType evaluatorType) throws Exception {

	}

}
