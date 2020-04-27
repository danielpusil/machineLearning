package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.moorepenrose.impl.RidgeRegressionTheory;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Veteran extends AbstractCrossValidationEvaluator {

    public Veteran() throws IOException {
        super(AbstractELMEvaluator.EvaluatorType.CV, "Veteran", new DataSet("src/resources-elm", "veteran.train", 7), new DataSet("src/resources-elm", "veteran.test", 7), 10, 50, new Sigmoid(), new MultiplicationMethod(null), 3000);
    }
}
