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
public class Usuario {
String nombreusuario;
String titulo;
String autor;
ArrayList<String> librosUsuario= new ArrayList();

    public Usuario(String nombreusuario, String titulo, String autor) {
        this.nombreusuario = nombreusuario;
        this.titulo = titulo;
        this.autor = autor;
        librosUsuario.add(titulo);
    }

    @Override
    public String toString() {
        return "Usuario{" + "librosUsuario=" + librosUsuario + '}';
    }
    

    

   



}
