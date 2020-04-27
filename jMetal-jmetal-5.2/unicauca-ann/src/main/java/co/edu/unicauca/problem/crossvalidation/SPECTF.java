package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class SPECTF extends AbstractCrossValidationEvaluator {

    public SPECTF() throws IOException {
        super(AbstractELMEvaluator.EvaluatorType.CV, "SPECTF", new DataSet("src/resources-elm", "SPECTF.train", 44), new DataSet("src/resources-elm", "SPECTF.test", 44), 10, 50, new Sigmoid(), new MultiplicationMethod(null), 3000);
    }

}
