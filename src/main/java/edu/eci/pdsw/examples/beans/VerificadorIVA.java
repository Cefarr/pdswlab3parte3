/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans;

import edu.eci.pdsw.examples.model.Plato;



/**
 *
 * @author 2098325
 */
public interface VerificadorIVA {
    
         /**
          * Esta funcion sirve para calcular el porcentaje del Iva respecto a la factura consumida por su cliente.
         * @param p Rcibe un parametro tipo plato
         * 
         */
    public float obtenerPorcentajeIva(Plato p );
    
}
