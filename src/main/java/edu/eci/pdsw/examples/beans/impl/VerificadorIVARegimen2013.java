/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.model.Plato;

/**
 *
 * @author 2098325
 */
public class VerificadorIVARegimen2013 implements VerificadorIVA {
    /**
     * @pre Recibe un plato valido para obtener el porcentaj del iva.
     * @pos Regrea un valor flotante con el valor del iva.
     * @param p Recibe un objeto tipo plato.
     * @return Retorna un flotante con el valor del iva
     * @throws ExcepcionManjeadorOrdenes Si ocurre algun error en la clase.
     */
    @Override
    public float obtenerPorcentajeIva(Plato p) {
        float total=(float) 0.0;
        total=p.getPrecio();
	total+=p.getPrecio()*0.29;
        return total;
    }
    
}
