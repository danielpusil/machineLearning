package co.edu.unicauca.problem.crossvalidation;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.function.impl.Sigmoid;
import co.edu.unicauca.moorepenrose.impl.MultiplicationMethod;
import co.edu.unicauca.problem.AbstractELMEvaluator;
import java.io.IOException;

public class Leaf extends AbstractCrossValidationEvaluator {

    public Leaf() throws IOException {
        super(AbstractELMEvaluator.EvaluatorType.CV, "Leaf", new DataSet("src/resources-elm", "leaf.train", 14), new DataSet("src/resources-elm", "leaf.test", 14), 10, 50, new Sigmoid(), new MultiplicationMethod(null), 3000);
    }
}
