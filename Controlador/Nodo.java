/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Jonathan Javier
 */
public class Nodo {
    private Object dato;
    private Nodo sig; // recursividad // puntero

    public Nodo() {
        this.dato = null;
        this.sig = null;
    }

    public Nodo(Object dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }
    
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
