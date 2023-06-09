/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_carlosmoncada;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author calol
 */
public class Lab8P1_CarlosMoncada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        ArrayList<Libro> libros = new ArrayList<Libro>();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        libros.add(new Libro("Miguel de cervantes", "Don quijote de la mancha"));
        libros.add(new Libro("Oscar Wilde", "El retrato de Dorian Gray"));
        libros.add(new Libro("Antoine de Saint", "El principito"));
        
        
        while (opcion != 4) {

            System.out.println("1.Biblioteca virtual ");
            System.out.println("2.Gestion de pedidos");
            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("1)Agregar ");
                    System.out.println("2)Buscar Libros");
                    System.out.println("3)Prestar ");
                    System.out.println("4)Devolver");
                    System.out.println("5)Ver sus libros disponibles");
                    System.out.println("6)Ver libros en biblioteca");
                    int opcioncase2 = entrada.nextInt();
                    if (opcioncase2 == 1) {
                        System.out.println("Ingreso Aregar");
                        libros.add(agregar());
                    } else if (opcioncase2 == 2) {
                        System.out.println("Ingreso buscar");
                        buscar(libros);
                    } else if (opcioncase2 == 3) {
                        System.out.println("Libros disponibles");
                        for (int i = 0; i < libros.size(); i++) {
                            System.out.println(libros.get(i));
                        }
                        System.out.println("Digite su nombre");
                        String nombre = entrada.nextLine();
                        nombre = entrada.nextLine();
                        System.out.println("Digite el titulo");
                        String titulo = entrada.nextLine();

                        System.out.println("Digite autor");
                        String autor = entrada.nextLine();
                        boolean bandera = false;
                        for (int i = 0; i < libros.size(); i++) {
                            if ((titulo.equalsIgnoreCase(libros.get(i).titulo) == true) && (autor.equalsIgnoreCase(libros.get(i).autor))) {
                                bandera = true;
                            }
                        }
                        if (bandera == false) {
                            System.out.println("No esta ese libro");
                        } else {
                            usuarios.add(new Usuario(nombre, titulo, autor));
                            libros.remove(prestar(titulo, libros));
                            System.out.println("Se ha agregado correctamente su libro");
                        }

                    } else if (opcioncase2 == 4) {
                        System.out.println("Devolver libros");
                        System.out.println("Digite su nombre: ");
                        String nombre = entrada.nextLine();
                        System.out.println("Digite el titulo del libro que va a devolver");
                        String titulo = entrada.nextLine();
                        System.out.println("Digite el autor del libro que va a devolver");
                        String autor = entrada.nextLine();
                        boolean bandera = false;
                        for (int i = 0; i < libros.size(); i++) {
                            if ((titulo.equalsIgnoreCase(libros.get(i).titulo) == true) && (autor.equalsIgnoreCase(libros.get(i).autor))) {
                                bandera = true;
                            }
                        }
                        if (bandera == false) {
                            System.out.println("No esta ese libro");
                        } else {
                            libros.add(new Libro(autor, titulo));
                            usuarios.remove(new Usuario(nombre, titulo, autor));
                        }

                    } else if (opcioncase2 == 5) {

                        System.out.println("Digite su nombre: ");
                        String nombre = entrada.nextLine();
                        nombre = entrada.nextLine();
                        System.out.println("Estos son sus libros");
                        boolean bandera = false;
                        for (int i = 0; i < usuarios.size(); i++) {

                            if (usuarios.get(i).nombreusuario.equalsIgnoreCase(nombre)) {
                                ArrayList<String> librosUsuario = usuarios.get(i).librosUsuario;
                                for (int j = 0; j < librosUsuario.size(); j++) {
                                    System.out.println(librosUsuario.get(j));
                                    bandera = true;
                                }
                            }

                        }
                        if (bandera == false) {
                            System.out.println("No tiene libros");
                        }
                    }else if(opcioncase2 == 6){
                        for (int i = 0; i < libros.size(); i++) {
                            System.out.println(libros);  
                        }
                    }
                    break;
                case 2:
                    System.out.println("1)Agregar productos");
                    System.out.println("2)Calcular el total de productos");
                    System.out.println("3)Mostrar lista de productos ");
                    int opcioncase3 = entrada.nextInt();
                    if (opcioncase3 == 1) {
                        pedidos.add(agregarpedido());
                    } else if (opcioncase3 == 2) {
                        Calcular(pedidos);
                    } else if (opcioncase3 == 3) {
                        mostrarLista(pedidos);
                    } else {
                        System.out.println("Opcion invalido");
                    }
                    break;

            }

        }
    }

    public static Libro agregar() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite el autor: ");
        String autor = entrada.nextLine();
        System.out.println("Digite el titulo: ");
        String titulo = entrada.nextLine();
        return new Libro(autor, titulo);
    }

    public static void buscar(ArrayList<Libro> libros) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Va a buscar por Autor o titulo A/T");
        char opcion = entrada.next().charAt(0);

        if (opcion == 'A') {
            System.out.println("Autores disponibles");
            for (int i = 0; i < libros.size(); i++) {
                System.out.println(libros.get(i).autor);
            }
            System.out.println("Digite el autor del Libro");
            String autor = entrada.nextLine();
            autor = entrada.nextLine();
            for (int i = 0; i < libros.size(); i++) {
                if (autor.equalsIgnoreCase(libros.get(i).autor)) {
                    System.out.println("Este es el nombre del titulo:" + libros.get(i).titulo + " con autor " + libros.get(i).autor);
                }
            }
        } else {
            System.out.println("Titulos disponibles");
            for (int i = 0; i < libros.size(); i++) {
                System.out.println(libros.get(i).titulo);
            }
            System.out.println("Digite el titulo del Libro");
            String titulo = entrada.nextLine();
            titulo = entrada.nextLine();
            for (int i = 0; i < libros.size(); i++) {
                if (titulo.equalsIgnoreCase(libros.get(i).titulo)) {
                    System.out.println("Este es el nombre del titulo:" + libros.get(i).titulo + " con autor " + libros.get(i).autor);
                }
            }

        }

    }

    public static int prestar(String titulo, ArrayList<Libro> libros) {
        Scanner entrada = new Scanner(System.in);
        int indice = 0;
        for (int i = 0; i < libros.size(); i++) {
            if (titulo == libros.get(i).titulo) {
                indice = i;
            }

        }

        return indice;
    }

    public static Pedido agregarpedido() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite nombre de su pedido");
        String nombrepedido = entrada.nextLine();
        System.out.println("Digite cuantos productos quiere ");

        int cantproductos = entrada.nextInt();
        ArrayList<Pedido> prueba = new ArrayList();
        for (int i = 0; i < cantproductos; i++) {
            System.out.println("Digite el nombre del producto:  " + (i + 1));
            String nombre = entrada.nextLine();
            nombre = entrada.nextLine();
            System.out.println("Digite el precio del producto: " + (i + 1));
            int precio = entrada.nextInt();

            Pedido producto = new Pedido(nombre, precio);

            prueba.add(producto);

        }
        Pedido Compra = new Pedido(nombrepedido, prueba);

        return Compra;
    }

    public static void Calcular(ArrayList<Pedido> pedidos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pedidos disponibles");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i).nombrepedido);    
        }
        System.out.println("Digite el nombre de su pedido");
        String nombrepedidosss = entrada.nextLine();
        int sumaprecio = 0;
        

        for (int i = 0; i < pedidos.size(); i++) {
            if (nombrepedidosss.equalsIgnoreCase(pedidos.get(i).nombrepedido)) {

                ArrayList<Pedido> productos = pedidos.get(i).productos;
                for (int j = 0; j < productos.size(); j++) {
                    System.out.println("Nombre del producto: "+productos.get(j).nombreproducto+" precio de producto "+productos.get(j).precio);
                    sumaprecio+=productos.get(j).precio;
                }

            }

        }
        System.out.println("Este es el total: " + sumaprecio);

    }

    public static void mostrarLista(ArrayList<Pedido> pedido) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite el nombre de su pedido: ");
        String nombrepedido = entrada.nextLine();
        for (int i = 0; i < pedido.size(); i++) {
            if (nombrepedido.equalsIgnoreCase(pedido.get(i).nombrepedido)) {
                ArrayList<Pedido> productos = pedido.get(i).productos;
                for (int j = 0; j < productos.size(); j++) {
                    System.out.println(productos.get(j));
                }

            }

        }

    }

}
