package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Wdbc extends AbstractCrossValidationEvaluator {

    public Wdbc() throws IOException {
        super(AbstractELMEvaluator.EvaluatorType.CV, "Wdbc", new DataSet("src/resources-elm", "wdbc.train", 30), new DataSet("src/resources-elm", "wdbc.test", 30), 10, 50, new Sigmoid(), new MultiplicationMethod(null), 3000);
    }
}
