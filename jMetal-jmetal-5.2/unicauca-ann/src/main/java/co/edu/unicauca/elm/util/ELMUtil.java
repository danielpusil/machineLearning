package co.edu.unicauca.elm.util;

import co.edu.unicauca.dataset.DataSet;
import co.edu.unicauca.elm.ELM;
import co.edu.unicauca.elm.ELM.ELMType;

public class ELMUtil {

	private ELMUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Obtains elm type given a data set
	 * 
	 * @param dataSet collection of data
	 * @return ELM type according to data set provided
	 */
	public static ELMType getELMType(DataSet dataSet) {
		return dataSet.getNumberClasses() == 1 ? ELM.ELMType.REGRESSION : ELM.ELMType.CLASSIFICATION;
	}
}
