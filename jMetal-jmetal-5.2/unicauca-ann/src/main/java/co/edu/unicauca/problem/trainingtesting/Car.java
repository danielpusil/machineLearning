package co.edu.unicauca.problem.trainingtesting;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;

import java.io.IOException;

public class Car extends TrainingTestingEvaluator {
	private static final long serialVersionUID = 1L;

	public Car() throws IOException {
		super(50, new DataSet("src/resources-elm", "car.train", 6), new DataSet("src/resources-elm", "car.test", 6),
				new Sigmoid(), new MultiplicationMethod(null), "Car", 3000);
	}
}
