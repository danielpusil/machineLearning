package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Seeds extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Seeds() throws IOException {
		super(50, new DataSet("src/resources-elm", "seeds.train", 7), new DataSet("src/resources-elm", "seeds.test", 7),
				new Sigmoid(), new MultiplicationMethod(null), "Seeds", 3000);
	}
}
