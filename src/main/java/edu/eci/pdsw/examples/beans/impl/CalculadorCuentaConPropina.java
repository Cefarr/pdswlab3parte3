/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.Orden;

/**
 *
 * @author 2098325
 */
public class CalculadorCuentaConPropina implements CalculadorCuenta {
    int res=0;
    @Override
    public int calcularCosto(Orden o) {
        return res;
        
    }
    
}
