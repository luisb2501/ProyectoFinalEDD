/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.listaSimple;

import Controlador.Nodo;

/**
 *
 * @author Jonathan Javier
 */
public class ListaSimple {
    protected Nodo cabecera;

    public ListaSimple() {
        this.cabecera = null;
    }
    
    public boolean estaVacia(){
        return (this.cabecera == null);
    }
    /**
        * @desc Permite agregar un objeto a la lista simple
        * @param Object objeto que se va a agregar
    */
    public void insertar(Object dato){
        Nodo tmp = new Nodo(dato, null);
        tmp.setSig(cabecera);
        cabecera = tmp;
    }
    
    /**
        * @desc Permite mostrar todos los elementos de la lista
    */
    public void imprimir(){
        if(!estaVacia()){
            Nodo tmp = cabecera;
            while (tmp != null) {                
                System.out.println(tmp.getDato().toString());
                tmp = tmp.getSig();
            }
        }else{
            System.out.println("La lista esta vacia");
        }
    }
    
    /**
        * @desc Permite ver uno de los objetos en cierta posicion
        * @param int posicion del objeto que se quiere visualizar
    */
    public Object verDatoPos(int pos){
        Object dato = null;
        if(!estaVacia() && pos >=0){
            Nodo tmp = cabecera;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSig();
                if(tmp == null){
                    break; 
                }
            }
            dato = (tmp != null) ? tmp.getDato() : null;
//            System.out.println(tmp.getDato());
        }
        return dato;
    }
     /**
        * @desc Permite calcular el tamaño de la lista de objetos
    */
    public int tamano() {
        int tamano = 0;
        if (!estaVacia()) {
            Nodo tmp = cabecera;
            while (tmp != null) {
                tamano++;
                tmp = tmp.getSig();
            }
        }
        return tamano;
    }
    
    /**
        * @desc Permite insertar un objeto en una posicion
        * @param Object objeto que se va a agregar
        * @param int posicion donde se agregará el objeto
    */
    public void insertar(Object dato, int pos) {
        if (estaVacia() || pos <= 0) {
            insertar(dato);
        } else {
            Nodo iterador = this.cabecera;
            for (int i = 0; i < pos; i++) {
                if (iterador.getSig() == null) {
                    break;
                } else {
                    iterador = iterador.getSig();
                }
            }
            Nodo tmp = new Nodo(dato, iterador.getSig());
            iterador.setSig(tmp);
        }
    }
     /**
        * @desc Permite agregar un objeto al final de la lista simple
        * @param Object objeto que se va a agregar
    */
    public void insertarFinal(Object dato) {
        insertar(dato, tamano() - 1);
    }
    
    /**
        * @desc Permite editar un objeto a la lista simple en cierta posicion
        * @param Object nuevo objeto que ocupará la posicion
        * @param int posicion donde se ubicará el objeto
    */
    public void editarPosicion(Object dato, int pos){
        if(pos >= 0 && pos < tamano()){
            if (pos == 0) {
                cabecera.setDato(dato);
            }else{
                Nodo aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSig();
                }
                aux.setDato(dato);
            }
        }else{
            System.out.println("Fuera de rango");
        }
    }
    
    /**
        * @desc Permite obtener solo un objeto en una posicion dada
        * @param int posicion que se desea ver
    */
    public Object obtenerPorPosicion(int pos) {
        Object aux = null;
        if (estaVacia()) {
            System.out.println("Lista Vacia");

        } else if (pos > tamano() - 1) {
            System.out.println("Fuera de rango");
        } else if (pos == 0) {
            aux = verDatoPos(pos);

        } else {
            Nodo iterador = cabecera;
            for (int i = 1; i < pos; i++) {
                if (iterador.getSig().getSig() == null) {
                    break;
                } else {
                    iterador = iterador.getSig();
                }
            }
            aux = iterador.getSig().getDato();
        }
        return aux;
    }
    
    /**
        * @desc Permite buscar objetos por dato
        * @param Object objeto que se desea buscar
    */
    public Object busquedaPorDatos(Object dato){
        
        String posicion = "";
        Object aux = null;
        if(estaVacia()){
            System.out.println("Lista vacia");
        }else{
            Nodo iterador = cabecera;
            int cont = 0;
            while(iterador!=null){
                if(iterador.getDato().equals(dato)){
                    aux = iterador.getDato();
                    posicion += cont + ";";
                }
                cont++;
                iterador = iterador.getSig(); 
            }
//            if(posicion != ""){
//                System.out.println("El dato se encuentra en las posiciones: " + posicion);
//            }else{
//                System.out.println("No existe el dato");
//            }
        }
        return aux;
    }
    
    /**
        * @desc Permite eliminar un objeto
        * @param Object objeto que se va a eliminar
    */
    public void eliminarPorDato(Object dato){
        if(busquedaPorDatos(dato)==null){
            System.out.println("No existe el dato");
        }else{
            if(cabecera.getDato().equals(dato)){
                cabecera=cabecera.getSig();
            }else{
                Nodo aux = cabecera;
                while(!(aux.getSig().getDato().equals(dato))){
                    aux = aux.getSig();
                }
                Nodo siguiente = aux.getSig().getSig();
                aux.setSig(siguiente);
            }
        }
    }
}
