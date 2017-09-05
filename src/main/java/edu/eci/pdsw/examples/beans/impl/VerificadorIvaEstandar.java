/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.model.ItemOrden;
import edu.eci.pdsw.examples.model.Plato;

/**
 *
 * @author 2098325
 */
public class VerificadorIvaEstandar implements VerificadorIVA{

    /** 
     * @pre Recibe un plato para obtener el iva.
     * @pos Regresa un float con el valor del Iva.
     * @param p Recibe un objeto tipo Plato.
     * @return Returna un flotante con el valor exacto del precio con el iva
     * @throws ExcepcionManjeadorOrdenes Si ocurre algun error en la clase.
     */
    @Override
    public float obtenerPorcentajeIva(Plato p) {
        float total=(float) p.getPrecio();
	total+=total*0.19;
        return total;
    }
    
}
