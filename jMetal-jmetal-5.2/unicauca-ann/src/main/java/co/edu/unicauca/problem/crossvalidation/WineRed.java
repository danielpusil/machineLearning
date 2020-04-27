package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class WineRed extends AbstractCrossValidationEvaluator {

    public WineRed() throws IOException {
        super(AbstractELMEvaluator.EvaluatorType.CV, "Wine(Red)", new DataSet("src/resources-elm", "wine(red).train", 11), new DataSet("src/resources-elm", "wine(red).test", 11), 10, 50, new Sigmoid(), new MultiplicationMethod(null), 3000);
    }
}