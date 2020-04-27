package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class AutoMpg extends TrainingTestingEvaluator {

	private static final long serialVersionUID = 1L;

	public AutoMpg() throws IOException {
		super(50, new DataSet("src/resources-elm", "autoMpg.train", 7),
				new DataSet("src/resources-elm", "autoMpg.test", 7), new Sigmoid(), new MultiplicationMethod(null),
				"AutoMpg", 3000);
	}
}
