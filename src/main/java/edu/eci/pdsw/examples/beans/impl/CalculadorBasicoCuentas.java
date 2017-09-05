package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.ItemOrden;

public class CalculadorBasicoCuentas implements CalculadorCuenta {
        /**
         * @pre Recibe una orden con todos los platos .
         * @pos Una sumatoria de todos los precios de los platos de la orden.
         * Esta es una interface que contiene los metodos que haran un mejor de demas clases.
         * @param o Recibe un objeto tipo Orden
         * @return total Retorna el costo de los items consumidos, en tipo flotante.
         * @throws ExcepcionManjeadorOrdenes Si ocurre algun error en el metodo.
         */

	public int calcularCosto(Orden o) {
		int total=0;
		for (ItemOrden p:o.getItemsOrden()){
			total+=p.getPrecio();
		}
		return total;
	}

}
