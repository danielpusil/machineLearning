package co.edu.unicauca.factory.algorithm;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.util.JMetalException;

import co.edu.unicauca.factory.parameters.AbstractParametersFactory;
import co.edu.unicauca.problem.AbstractELMEvaluator;

/**
 * Creates algorithms as needed to run elm problems
 */
public class AlgorithmFactory {

	private DifferentialEvolutionFactory de;
	private HillClimbingFactory hc;
	private IHDELSFactory ihdels;
	private MOSFactory mos;
	private MTSFactory mts;
	private SolisAndWetsFactory sw;
	private RandomFactory random;
	private HSVariansFactory hsVariansFactory;

	public AlgorithmFactory(AbstractParametersFactory parametersFactory) {
		de = new DifferentialEvolutionFactory(parametersFactory);
		hc = new HillClimbingFactory(parametersFactory);
		ihdels = new IHDELSFactory(parametersFactory);
		mos = new MOSFactory(parametersFactory);
		mts = new MTSFactory(parametersFactory);
		sw = new SolisAndWetsFactory(parametersFactory);
		random = new RandomFactory(parametersFactory);
		hsVariansFactory = new HSVariansFactory(parametersFactory);
	}

	public Algorithm<?> getAlgorithm(String name, AbstractELMEvaluator.EvaluatorType evaluatorType,
			DoubleProblem problem) throws Exception {
		switch (name) {
		case "DECC_G":
			return de.getAlgorithm(name, evaluatorType, problem).build();
		case "DEUnicauca":
			return de.getAlgorithm(name, evaluatorType, problem).build();
		case "SaNSDE":
			return de.getAlgorithm(name, evaluatorType, problem).build();
		case "MemeticED":
			return de.getAlgorithm(name, evaluatorType, problem).build();
		case "MOS":
			return mos.getAlgorithm(name, evaluatorType, problem).build();
		case "MTS_LS1":
			return mts.getAlgorithm(name, evaluatorType, problem).build();
		case "SolisAndWets":
			return sw.getAlgorithm(name, evaluatorType, problem).build();
		case "IHDELS":
			return ihdels.getAlgorithm(name, evaluatorType, problem).build();
		case "SaDE":
			return de.getAlgorithm(name, evaluatorType, problem).build();
		case "HillClimbing":
			return hc.getAlgorithm(name, evaluatorType, problem).build();
		case "Random":
			return random.getAlgorithm(name, evaluatorType, problem).build();
		case "HS":
			return hsVariansFactory.getAlgorithm(name, evaluatorType, problem).build();
		case "IHS":
			return hsVariansFactory.getAlgorithm(name, evaluatorType, problem).build();
		case "GHS":
			return hsVariansFactory.getAlgorithm(name, evaluatorType, problem).build();
		case "NGHS":
			return hsVariansFactory.getAlgorithm(name, evaluatorType, problem).build();
		default:
			throw new JMetalException("Algorithm " + name + " not exists");
		}
	}

}
