package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Haberman extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Haberman() throws IOException {
		super(50, new DataSet("src/resources-elm", "haberman.train", 3),
				new DataSet("src/resources-elm", "haberman.test", 3), new Sigmoid(), new MultiplicationMethod(null),
				"Haberman", 3000);
	}
}
