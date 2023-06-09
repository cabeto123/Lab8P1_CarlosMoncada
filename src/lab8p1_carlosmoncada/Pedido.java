/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_carlosmoncada;

import java.util.ArrayList;

/**
 *
 * @author calol
 */
public class Pedido {
 String nombrepedido;
 String nombreproducto;
 int precio;
 ArrayList<Pedido> productos= new <Pedido>ArrayList();


    public Pedido(String nombreproducto, int precio) {
        this.nombreproducto = nombreproducto;
        this.precio = precio;
    }

    public Pedido(String nombrepedido,ArrayList<Pedido> productos) {
        this.nombrepedido = nombrepedido;
         this.productos=productos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "producto=  " + nombreproducto + ",  Precio   "+precio+'}';
    }
    

    
    
 
}
