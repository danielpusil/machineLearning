package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Housing extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Housing() throws IOException {
		super(50, new DataSet("src/resources-elm", "housing.train", 13),
				new DataSet("src/resources-elm", "housing.test", 13), new Sigmoid(), new MultiplicationMethod(null),
				"Housing", 3000);
	}
}
