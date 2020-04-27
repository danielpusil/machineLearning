package co.edu.unicauca.factory.algorithm;

import java.util.Comparator;

import org.uma.jmetal.algorithm.singleobjective.differentialevolution.DECC_GBuilder;
import org.uma.jmetal.algorithm.singleobjective.differentialevolution.DEUnicaucaBuilder;
import org.uma.jmetal.algorithm.singleobjective.differentialevolution.MemeticEDBuilder;
import org.uma.jmetal.algorithm.singleobjective.differentialevolution.SaDEBuilder;
import org.uma.jmetal.algorithm.singleobjective.differentialevolution.SaNSDEBuilder;
import org.uma.jmetal.operator.impl.crossover.DifferentialEvolutionCrossover;
import org.uma.jmetal.operator.impl.selection.DifferentialEvolutionSelection;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.util.AlgorithmBuilder;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.comparator.ObjectiveComparator;

import co.edu.unicauca.factory.parameters.AbstractParametersFactory;
import co.edu.unicauca.problem.AbstractELMEvaluator;

/**
 * Factory to differential evolution algorithms builders, with configuration
 * needed for elm problem.
 */
public class DifferentialEvolutionFactory extends AbstractBuilderFactory {

	private static final String CURRENT_TO_BEST_1_BIN = "current-to-best/1/bin";
	private static final String POPULATION = "POPULATION";
	private static final String RAND_1_BIN = "rand/1/bin";
	private static final String MEMETIC_ED = "MemeticED";
	private static final String SA_NSDE = "SaNSDE";
	private static final String SA_DE = "SaDE";
	private static final String DE_UNICAUCA = "DEUnicauca";
	/**
	 * Default configuration for DE
	 */
	private double cRDE;
	private double fDE;
	private int populationDE;
	/**
	 * Default configuration SaDE
	 */
	private double cR1SADE;
	private double f1SADE;
	private double cR2SADE;
	private double f2SADE;
	private int populationSaDE;
	/**
	 * Default configuration SaNSDE
	 */
	private double cR1SANSDE;
	private double f1SANSDE;
	private double cR2SANSDE;
	private double f2SANSDE;
	private int populationSANSDE;
	/**
	 * Default configuration for MemeticDE
	 */
	private double cRMemeticDE;
	private double fMemeticDE;
	private int populationMemetic;
	private static final Comparator<DoubleSolution> COMPARATOR_MEMETIC = new ObjectiveComparator<>(0,
			ObjectiveComparator.Ordering.DESCENDING);

	private int dECCGPOPULATION;

	public DifferentialEvolutionFactory(AbstractParametersFactory parametersFactory) {
		super(parametersFactory);

	}

	@Override
	public AlgorithmBuilder<?> getAlgorithm(String name, AbstractELMEvaluator.EvaluatorType evaluatorType,
			DoubleProblem problem) throws Exception {
		this.evaluatorType = evaluatorType;
		int evaluations = evaluatorType == AbstractELMEvaluator.EvaluatorType.TT ? EVALUATIONS_TT : EVALUATIONS_CV;
		AlgorithmBuilder<?> builder = null;
		this.loadAlgorithmValues(name, evaluatorType);
		switch (name) {
		case DE_UNICAUCA:
			builder = this.getDEUnicauca(evaluations, problem);
			break;
		case SA_DE:
			builder = this.getSaDE(evaluations, problem);
			break;
		case SA_NSDE:
			builder = this.getSaNSDE(evaluations, problem);
			break;
		case "DECC_G":
			builder = this.getDECCG(evaluations, problem);
			break;
		case MEMETIC_ED:
			builder = this.getMemeticED(evaluations, problem);
			break;
		default:
			throw new JMetalException("Algorithm " + name + " not exists");
		}
		return builder;
	}

	private AlgorithmBuilder<?> getDEUnicauca(int evaluations, DoubleProblem problem) {
		return new DEUnicaucaBuilder(problem).setPopulationSize(populationDE)
				.setCrossover(new DifferentialEvolutionCrossover(cRDE, fDE, RAND_1_BIN))
				.setSelection(new DifferentialEvolutionSelection()).setMaxEvaluations(evaluations)
				.setPenalizeValue(PENALIZE_VALUE).setComparator(COMPARATOR);
	}

	private AlgorithmBuilder<?> getSaDE(int evaluations, DoubleProblem problem) {
		return new SaDEBuilder(problem).setPopulationSize(populationSaDE)
				.setCrossoverOperator(new DifferentialEvolutionCrossover(cR1SADE, f1SADE, RAND_1_BIN))
				.setCrossoverOperator2(new DifferentialEvolutionCrossover(cR2SADE, f2SADE, CURRENT_TO_BEST_1_BIN))
				.setSelectionOperator(new DifferentialEvolutionSelection()).setMaxEvaluations(evaluations)
				.setPenalizeValue(PENALIZE_VALUE).setComparator(COMPARATOR);
	}

	private AlgorithmBuilder<?> getSaNSDE(int evaluations, DoubleProblem problem) {
		return new SaNSDEBuilder(problem).setPopulationSize(populationSANSDE)
				.setCrossover(new DifferentialEvolutionCrossover(cR1SANSDE, f1SANSDE, RAND_1_BIN))
				.setCrossoverOperator2(new DifferentialEvolutionCrossover(cR2SANSDE, f2SANSDE, CURRENT_TO_BEST_1_BIN))
				.setSelection(new DifferentialEvolutionSelection()).setMaxEvaluations(evaluations)
				.setPenalizeValue(PENALIZE_VALUE).setComparator(COMPARATOR);
	}

	private AlgorithmBuilder<?> getDECCG(int evaluations, DoubleProblem problem) {
		DECC_GBuilder builder = new DECC_GBuilder(problem)
				.setDEBuilder(new DEUnicaucaBuilder(problem)
						.setCrossover(new DifferentialEvolutionCrossover(cRDE, fDE, RAND_1_BIN))
						.setSelection(new DifferentialEvolutionSelection()))
				.setSaNSDEBuilder(new SaNSDEBuilder(problem)
						.setCrossover(new DifferentialEvolutionCrossover(cR1SANSDE, f1SANSDE, RAND_1_BIN))
						.setCrossoverOperator2(
								new DifferentialEvolutionCrossover(cR2SANSDE, f2SANSDE, CURRENT_TO_BEST_1_BIN)))
				.setMaxEvaluations(evaluations).setPenalizeValue(PENALIZE_VALUE).setComparator(COMPARATOR);

		if (evaluatorType == AbstractELMEvaluator.EvaluatorType.CV) {
			builder.setPopulationSize(dECCGPOPULATION).setSubcomponets(6).setFEs(30).setwFes(40);
		} else {
			builder.setPopulationSize(dECCGPOPULATION).setSubcomponets(10).setFEs(70).setwFes(100);
		}

		return builder;
	}

	private AlgorithmBuilder<?> getMemeticED(int evaluations, DoubleProblem problem) {
		return new MemeticEDBuilder(problem).setPopulationSize(populationMemetic)
				.setCrossover(new DifferentialEvolutionCrossover(cRMemeticDE, fMemeticDE, CURRENT_TO_BEST_1_BIN))
				.setSelection(new DifferentialEvolutionSelection()).setMaxEvaluations(evaluations - 1)
				.setComparator(COMPARATOR_MEMETIC);
	}

	@Override
	protected void loadAlgorithmValues(String name, AbstractELMEvaluator.EvaluatorType evaluatorType) throws Exception {

		cRDE = parametersFactory.getValue("CR", evaluatorType, DE_UNICAUCA);
		fDE = parametersFactory.getValue("F", evaluatorType, DE_UNICAUCA);
		populationDE = (int) parametersFactory.getValue(POPULATION, evaluatorType, DE_UNICAUCA);

		cR1SADE = parametersFactory.getValue("CR1", evaluatorType, SA_DE);
		f1SADE = parametersFactory.getValue("F1", evaluatorType, SA_DE);
		cR2SADE = parametersFactory.getValue("CR2", evaluatorType, SA_DE);
		f2SADE = parametersFactory.getValue("F2", evaluatorType, SA_DE);
		populationSaDE = (int) parametersFactory.getValue(POPULATION, evaluatorType, SA_DE);

		cR1SANSDE = parametersFactory.getValue("CR1", evaluatorType, SA_NSDE);
		f1SANSDE = parametersFactory.getValue("F1", evaluatorType, SA_NSDE);
		cR2SANSDE = parametersFactory.getValue("CR2", evaluatorType, SA_NSDE);
		f2SANSDE = parametersFactory.getValue("F2", evaluatorType, SA_NSDE);
		populationSANSDE = (int) parametersFactory.getValue(POPULATION, evaluatorType, SA_NSDE);

		cRMemeticDE = parametersFactory.getValue("CR", evaluatorType, MEMETIC_ED);
		fMemeticDE = parametersFactory.getValue("F", evaluatorType, MEMETIC_ED);
		populationMemetic = (int) parametersFactory.getValue(POPULATION, evaluatorType, MEMETIC_ED);

		dECCGPOPULATION = (int) parametersFactory.getValue(POPULATION, evaluatorType, "DECC_G");
	}

}
