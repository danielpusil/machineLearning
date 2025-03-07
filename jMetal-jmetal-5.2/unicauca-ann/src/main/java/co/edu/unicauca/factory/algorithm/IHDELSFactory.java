package co.edu.unicauca.factory.algorithm;

import co.edu.unicauca.factory.parameters.AbstractParametersFactory;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import org.uma.jmetal.algorithm.local_search.LocalSearch;
import org.uma.jmetal.algorithm.singleobjective.differentialevolution.SaDEBuilder;
import org.uma.jmetal.algorithm.singleobjective.ihdels.IHDELSBuilder;
import org.uma.jmetal.algorithm.singleobjective.ihdels.LSHillClimbing;
import org.uma.jmetal.algorithm.singleobjective.ihdels.LSMTS_LS1;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.util.AlgorithmBuilder;
import org.uma.jmetal.util.JMetalException;

/**
 * Factory to IHDELS algorithms builders, with configuration needed for elm
 * problem.
 */
public class IHDELSFactory extends AbstractBuilderFactory {
	private static final String IHDELS = "IHDELS";
	private DifferentialEvolutionFactory deFactory;
	private MTSFactory mtsFactory;
	private HillClimbingFactory hcFactory;

	private int fEDeIHDELS;
	private int fELsIHDLES;
	private int populationIHDELS;
	private int restartIHDELS;
	private double aIHDELS;
	private double bIHDELS;
	private double thresholdIHDELS;

	public IHDELSFactory(AbstractParametersFactory parametersFactory) {
		super(parametersFactory);
		deFactory = new DifferentialEvolutionFactory(parametersFactory);
		mtsFactory = new MTSFactory(parametersFactory);
		hcFactory = new HillClimbingFactory(parametersFactory);
	}

	@Override
	public AlgorithmBuilder<?> getAlgorithm(String name, AbstractELMEvaluator.EvaluatorType evaluatorType,
			DoubleProblem problem) throws Exception {
		this.evaluatorType = evaluatorType;
		int evaluations = evaluatorType == AbstractELMEvaluator.EvaluatorType.TT ? EVALUATIONS_TT : EVALUATIONS_CV;
		AlgorithmBuilder<?> builder = null;
		this.loadAlgorithmValues(name, evaluatorType);
		if (IHDELS.equals(name)) {
			builder = this.getIHDELS(evaluations, problem);
		} else {
			throw new JMetalException("Algorithm " + name + " not exists");
		}
		return builder;
	}

	private AlgorithmBuilder<?> getIHDELS(int evaluations, DoubleProblem problem) throws Exception {
		LocalSearch<?> hillClimbing = new LSHillClimbing(
				hcFactory.getAlgorithm("HillClimbing", this.evaluatorType, problem));
		LocalSearch<?> mtsls1 = new LSMTS_LS1(mtsFactory.getAlgorithm("MTS_LS1", this.evaluatorType, problem));
		SaDEBuilder sadeBuilder = (SaDEBuilder) deFactory.getAlgorithm("SaDE", this.evaluatorType, problem);

		return new IHDELSBuilder(problem).addLocalSearch(mtsls1).addLocalSearch(hillClimbing).setComparator(COMPARATOR)
				.setMaxEvaluations(evaluations).setFE_DE(fEDeIHDELS).setFE_LS(fELsIHDLES)
				.setPopulation_size(populationIHDELS).setReStart(restartIHDELS).setSearchDomain(aIHDELS, bIHDELS)
				.setThreshold(thresholdIHDELS).setSaDEBuilder(sadeBuilder);
	}

	@Override
	protected void loadAlgorithmValues(String name, AbstractELMEvaluator.EvaluatorType evaluatorType) throws Exception {
		fEDeIHDELS = (int) parametersFactory.getValue("FE_DE", evaluatorType, IHDELS);
		fELsIHDLES = (int) parametersFactory.getValue("FE_LS", evaluatorType, IHDELS);
		populationIHDELS = (int) parametersFactory.getValue("POPULATION", evaluatorType, IHDELS);
		restartIHDELS = (int) parametersFactory.getValue("RESTART", evaluatorType, IHDELS);
		aIHDELS = parametersFactory.getValue("A", evaluatorType, IHDELS);
		bIHDELS = parametersFactory.getValue("B", evaluatorType, IHDELS);
		thresholdIHDELS = parametersFactory.getValue("THRESHOLD", evaluatorType, IHDELS);

	}
}
