package co.edu.unicauca.factory.algorithm;

import org.uma.jmetal.algorithm.singleobjective.harmonysearch.GHSBuilder;
import org.uma.jmetal.algorithm.singleobjective.harmonysearch.HSBuilder;
import org.uma.jmetal.algorithm.singleobjective.harmonysearch.IHSBuilder;
import org.uma.jmetal.algorithm.singleobjective.harmonysearch.NGHSBuilder;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.util.AlgorithmBuilder;
import org.uma.jmetal.util.JMetalException;

import co.edu.unicauca.factory.parameters.AbstractParametersFactory;
import co.edu.unicauca.problem.AbstractELMEvaluator;

/**
 *
 * @author Daniel Pusil <danielpusil@unicauca.edu.co>
 */
public class HSVariansFactory extends AbstractBuilderFactory {

	private int hMS;
	private double hMCR;
	private double pAR;
	private double bW;
	private double bWMin;
	private double bWMax;
	private double pARMax;
	private double pARMin;
	private double pM;

	public HSVariansFactory(AbstractParametersFactory parametersFactory) {
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
			case "HS":
				builder = this.getHS(evaluations, problem);
				break;
			case "IHS":
				builder = this.getIHS(evaluations, problem);
				break;
			case "GHS":
				builder = this.getGHS(evaluations, problem);
				break;
			case "NGHS":
				builder = this.getNGHS(evaluations, problem);
				break;
			default:
				throw new JMetalException("Algorithm " + name + " not exists");
		}
		return builder;
	}

	@Override
	protected void loadAlgorithmValues(String name, AbstractELMEvaluator.EvaluatorType evaluatorType) throws Exception {
		hMS = (int) parametersFactory.getValue("HMS", evaluatorType, "HS");
		hMCR = parametersFactory.getValue("HMCR", evaluatorType, "HS");
		pAR = parametersFactory.getValue("PAR", evaluatorType, "HS");
		bW = parametersFactory.getValue("BW", evaluatorType, "HS");
		pARMax = parametersFactory.getValue("PARMax", evaluatorType, "IHS");
		pARMin = parametersFactory.getValue("PARMin", evaluatorType, "IHS");
		bWMax = parametersFactory.getValue("BWMax", evaluatorType, "IHS");
		bWMin = parametersFactory.getValue("BWMin", evaluatorType, "IHS");
		pM = parametersFactory.getValue("PM", evaluatorType, "NGHS");
	}

	public AlgorithmBuilder<?> getHS(int evaluations, DoubleProblem problem) {
		return new HSBuilder(problem).setHMS(hMS).setHMCR(hMCR).setPAR(pAR).setBW(bW).setMaxEvaluations(evaluations);
	}

	public AlgorithmBuilder<?> getIHS(int evaluations, DoubleProblem problem) {
		return new IHSBuilder(problem).setHMS(hMS).setHMCR(hMCR).setPARMAX(pARMax).setPARMIN(pARMin).setBWMAX(bWMax)
				.setBWMIN(bWMin).setMaxEvaluations(evaluations);

	}

	public AlgorithmBuilder<?> getGHS(int evaluations, DoubleProblem problem) {
		return new GHSBuilder(problem).setHMS(hMS).setHMCR(hMCR).setPARMAX(pARMax).setPARMIN(pARMin)
				.setMaxEvaluations(evaluations);
	}

	public AlgorithmBuilder<?> getNGHS(int evaluations, DoubleProblem problem) {
		return new NGHSBuilder(problem).setHMS(hMS).setPM(pM).setMaxEvaluations(evaluations);
	}
}
