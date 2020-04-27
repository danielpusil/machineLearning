package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class WineRed extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public WineRed() throws IOException {
		super(50, new DataSet("src/resources-elm", "wine(red).train", 11),
				new DataSet("src/resources-elm", "wine(red).test", 11), new Sigmoid(), new MultiplicationMethod(null),
				"Wine(Red)", 3000);
	}
}