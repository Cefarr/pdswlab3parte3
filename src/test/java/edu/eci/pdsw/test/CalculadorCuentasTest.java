/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.impl.CalculadorBasicoCuentas;
import edu.eci.pdsw.examples.beans.impl.CalculadorCuentaConIva;
import edu.eci.pdsw.examples.beans.impl.CalculadorCuentaConPropina;
import edu.eci.pdsw.examples.model.Bebida;
import edu.eci.pdsw.examples.model.ExcepcionManejadorOrdenes;
import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.model.Plato;
import edu.eci.pdsw.examples.services.ManejadorOrdenes;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Diseño de pruebas:
 * 
 * Clases de equivalencia:
 *  
 *      CE1: Si la propina es igual a 0, y el plato ya incluye el iva, es decir iva=0(NO se cobra un valor adicional).
 *           El valor del plato o de los platos.
 *          
 *      CE2: EL iva es igual 0, y la propina es igual al 10% solo si el costo supera los 15000 pesos.
 *           Resultado esperado: SI el costo supera los 15 mil, ese valor + un dies % del costo.
 * 
 *      CE3: La propina es igual a 0, iva es igual = 29% / 19%, mas el costo.
 *           Resultado esperado: EL iva mas el costo del producto.
 *  
 * Condiciones de frontera:
 * 
 *      CF1: Cuando propina y el iva son iguales a 0 y el costo si esta full.
 *           Clases de equivalencia relacionadas:
 *           Resultado esperado: EL costo total de los precios.
 *      CF2: La propina es igual a 0, y el costo supera los 15 mil se le suma un 10 % adicional.
 *           Clases de equivalencia relacionadas:
 *           Resultado esperado: El costo total o el costo mas la propina.
 *      CF3: .
 *           Clases de equivalencia relacionadas:
 *           Resultado esperado: EL costo total de los precios.
 *      
 */
public class CalculadorCuentasTest {
    int res=0;
    @Test
    public void clasesEquivalenciaCE1() throws ExcepcionManejadorOrdenes{
        Orden o = new Orden();
        o.agregarItemOrden(new Plato("pizza", 7500));
        o.agregarItemOrden(new Bebida("pepsi 300ml", 3900,1000));
        o.agregarItemOrden(new Plato("hamburguesa", 8000));
        o.agregarItemOrden(new Bebida("sprite 300ml", 200,2000));
        CalculadorBasicoCuentas prime=new CalculadorBasicoCuentas();
        res=prime.calcularCosto(o);
        assertEquals(19600, res);
        res=0;
    }
    @Test
    public void clasesEquivalenciaCE2() throws ExcepcionManejadorOrdenes{
        Orden o = new Orden();
        o.agregarItemOrden(new Plato("pizza", 7500));
        o.agregarItemOrden(new Bebida("pepsi 300ml", 3900,1000));
        o.agregarItemOrden(new Plato("hamburguesa", 8000));
        o.agregarItemOrden(new Bebida("sprite 300ml", 200,2000));
        CalculadorCuentaConPropina prime=new CalculadorCuentaConPropina();
        res=prime.calcularCosto(o);
        assertEquals(21560, res);
        res=0;
    }    
    @Test
    public void clasesEquivalenciaCE3() throws ExcepcionManejadorOrdenes{
        Orden o = new Orden();
        o.agregarItemOrden(new Plato("pizza", 01));
        o.agregarItemOrden(new Plato("chuquitos", 10000));
        o.agregarItemOrden(new Plato("hamburguesa", 3000));
        o.agregarItemOrden(new Plato("lolitas 300ml", 2000));
        
        CalculadorCuentaConIva prime=new CalculadorCuentaConIva();
        res=prime.calcularCosto(o);
        assertEquals(19600, prime.calcularCosto(o));
        res=0;
    }    
    //Condiciones de frontera
    @Test
    public void CondicionFronteraCE2() throws ExcepcionManejadorOrdenes{
        Orden o = new Orden();
        o.agregarItemOrden(new Plato("pizza", 7500));
        o.agregarItemOrden(new Bebida("pepsi 300ml", 3900,1000));
        o.agregarItemOrden(new Plato("hamburguesa", 8000));
        o.agregarItemOrden(new Bebida("sprite 300ml", 200,2000));
        CalculadorCuentaConIva prime=new CalculadorCuentaConIva();
        res=prime.calcularCosto(o);
        System.out.println(res);
        assertEquals(16500, res);
    }
    @Test
    public void CondicionFronteraCE21() throws ExcepcionManejadorOrdenes{
        Orden o = new Orden();
        o.agregarItemOrden(new Plato("pizza", 100));
        o.agregarItemOrden(new Bebida("pepsi 300ml", 10000,1000));
        o.agregarItemOrden(new Plato("hamburguesa", 2900));
        o.agregarItemOrden(new Bebida("sprite 300ml", 2000,2000));
        CalculadorCuentaConIva prime=new CalculadorCuentaConIva();
        res=prime.calcularCosto(o);
        assertEquals(15000, res);
    }    
    
    @Test
    public void CondicionFronteraCE22() throws ExcepcionManejadorOrdenes{
        Orden o = new Orden();
        o.agregarItemOrden(new Plato("pizza", 100));
        o.agregarItemOrden(new Bebida("pepsi 300ml", 10000,1000));
        o.agregarItemOrden(new Plato("hamburguesa", 2800));
        o.agregarItemOrden(new Bebida("sprite 300ml", 2000,2000));
        CalculadorCuentaConIva prime=new CalculadorCuentaConIva();
        res=prime.calcularCosto(o);
        assertEquals(14900, res);
    }    
    
}
