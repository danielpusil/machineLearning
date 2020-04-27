package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class AutoMpg extends AbstractCrossValidationEvaluator {

    public AutoMpg() throws IOException {
        super(AbstractELMEvaluator.EvaluatorType.CV, "AutoMpg", new DataSet("src/resources-elm", "autoMpg.train", 7), new DataSet("src/resources-elm", "autoMpg.test", 7), 10, 50, new Sigmoid(), new MultiplicationMethod(null), 3000);
    }

}