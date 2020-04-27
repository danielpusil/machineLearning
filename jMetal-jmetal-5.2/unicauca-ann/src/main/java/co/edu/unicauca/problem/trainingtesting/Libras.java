package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Libras extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Libras() throws IOException {
		super(50, new DataSet("src/resources-elm", "libras.train", 90),
				new DataSet("src/resources-elm", "libras.test", 90), new Sigmoid(), new MultiplicationMethod(null),
				"Libras", 3000);
	}
}
