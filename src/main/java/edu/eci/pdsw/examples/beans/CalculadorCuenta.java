package edu.eci.pdsw.examples.beans;

import edu.eci.pdsw.examples.model.Orden;

public interface CalculadorCuenta {
        /**
         * Esta es una interface que contiene los metodos que haran un mejor de demas clases.
         * @param o 
         */
        //@pre, @pos, @param, @throws.
	public int calcularCosto(Orden o);
	
}
