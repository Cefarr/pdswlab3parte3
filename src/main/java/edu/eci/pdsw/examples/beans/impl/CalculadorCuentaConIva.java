/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.model.ItemOrden;
import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.model.Plato;
import edu.eci.pdsw.examples.model.Bebida;

/**
 *
 * @author 2098325
 */
//@pre, @pos, @param, @throws.
public class CalculadorCuentaConIva implements CalculadorCuenta {
    /**
     * @pre Se cobra un 19% sobre todos los platos o aplicando un iva diferencial a cada plato en la orden.
     * @pos Recibe un rsultado con el total del costo(iva incluido) en cada plato.
     * @param o Recibe un objeto tipo Orden para calcular asi el costo de la factura y agregar el Iva.
     * @return Returna un entero con el costo total de la orden
     * @throws ExcepcionManjeadorOrdenes Si ocurre algun error en la clase.
     */
    VerificadorIVA prim;
    @Override
    public int calcularCosto(Orden o) {
        
        int tola1=0;
       	int total=0;
	for (ItemOrden p:o.getItemsOrden()){
            String gaseosa=p.getNombre();
            if(("pepsi"==gaseosa)||("cocacola"==gaseosa)||("sprite"==gaseosa)){
                Bebida yu=(Bebida)p;
                //total+=0;
                if(yu.getCalorias()>1000){
                    prim= new VerificadorIVARegimen2013();
                    tola1=(int)prim.obtenerPorcentajeIva((Plato) p);
                }else{
                    prim=new VerificadorIvaEstandar();
                    tola1=(int)prim.obtenerPorcentajeIva((Plato) p);            
                }
            }else{ 
                prim=new VerificadorIvaEstandar();
                tola1=(int)prim.obtenerPorcentajeIva((Plato) p);
            }

            total+=p.getPrecio()+tola1;
	}
        return (int) total;
    }
    
}
