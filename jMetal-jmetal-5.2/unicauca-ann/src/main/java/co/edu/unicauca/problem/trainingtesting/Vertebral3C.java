package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Vertebral3C extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Vertebral3C() throws IOException {
		super(50, new DataSet("src/resources-elm", "vertebral(3c).train", 6),
				new DataSet("src/resources-elm", "vertebral(3c).test", 6), new Sigmoid(),
				new MultiplicationMethod(null), "Vertebral(3C)", 3000);
	}
}