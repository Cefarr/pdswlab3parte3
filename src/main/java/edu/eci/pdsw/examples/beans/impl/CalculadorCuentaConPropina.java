/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.ItemOrden;
import edu.eci.pdsw.examples.model.Orden;

/**
 * @author 2098325
 */
public class CalculadorCuentaConPropina implements CalculadorCuenta {
    
    /**
     * @pre Se cobra un valor adicional del 10%, si la cuenta supera los 15 mil pesos.
     * @pos Retorna el total con el valor de la orden + la propina.
     * @param o Recibe un objeto tipo orden.
     * @return Retorna un entero con el costo de la orden.
     * @throws ExcepcionManjeadorOrdenes Si ocurre algun error en la clase.
    
     */
    @Override
    public int calcularCosto(Orden o) {
        int total=0;
        for (ItemOrden p:o.getItemsOrden()){
            total+=p.getPrecio();
	}
        if(total>15000){
            total+=total*0.1;
        }
        return total;
        
    }
    
}
