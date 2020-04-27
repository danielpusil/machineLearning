package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Hill extends AbstractCrossValidationEvaluator {

    public Hill() throws IOException {
        super(AbstractELMEvaluator.EvaluatorType.CV, "Hill", new DataSet("src/resources-elm", "hill.train", 100), new DataSet("src/resources-elm", "hill.test", 100), 10, 50, new Sigmoid(), new MultiplicationMethod(null), 3000);
    }
}
