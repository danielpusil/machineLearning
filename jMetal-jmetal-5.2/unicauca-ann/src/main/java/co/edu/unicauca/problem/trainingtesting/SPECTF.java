package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class SPECTF extends TrainingTestingEvaluator {

	private static final long serialVersionUID = 1L;

	public SPECTF() throws IOException {
		super(50, new DataSet("src/resources-elm", "SPECTF.train", 44),
				new DataSet("src/resources-elm", "SPECTF.test", 44), new Sigmoid(), new MultiplicationMethod(null),
				"SPECTF", 3000);
	}
}
