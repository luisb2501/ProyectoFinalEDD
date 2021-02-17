/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.listaSimple.ListaSimple;

/**
 *
 * @author ASUS
 */
public interface InterfazDAO {
    /**
        * @desc Permite guardar el .json en la ubicacion dada
        * @param Object objeto que se guardará en el archivo
    */
    public void guardar(Object o)throws Exception;
    
    /**
        * @desc Permite modificar el fichero
        * @param ListaSimple nueva lista que estará en el archivo
    */
    public void modificar(ListaSimple lista)throws Exception;
    
    /**
        * @desc Permite crear una lista con los elementos que se agregaran al archivo
        * @return ListaSimple - obtiene la lista de objetos
    */
    public ListaSimple listar();
}
