/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;


import Controlador.listaSimple.ListaSimple;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 *
 * @author ASUS
 */
public class AdaptadorDAO implements InterfazDAO{
    private  Conexion conexion;
    private Class clazz;

    public AdaptadorDAO(Conexion conexion, Class clazz) {
        this.conexion = conexion;
        this.clazz = clazz;
    }
    
    /**
        * @desc Permite crear una lista con los elementos que se agregaran al archivo
        * @return ListaSimple - obtiene la lista de objetos
    */
    @Override
    public ListaSimple listar() {
        ListaSimple lista = new ListaSimple();
        try {
            lista = (ListaSimple) conexion.getXtrStream().fromXML(new FileReader(conexion.getDireccion()+ File.separatorChar + clazz.getSimpleName() + ".json"));

        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return lista;
    }
    
    /**
        * @desc Permite guardar el .json en la ubicacion dada
        * @param Object objeto que se guardará en el archivo
    */
    @Override
    public void guardar(Object o) throws Exception {
        ListaSimple lista = listar();
        lista.insertar(o);
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getDireccion()+ File.separatorChar + clazz.getSimpleName() + ".json"));
    }
    
    /**
        * @desc Permite modificar el fichero
        * @param ListaSimple nueva lista que estará en el archivo
    */
    @Override
    public void modificar(ListaSimple lista) throws Exception {
          conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getDireccion()+ File.separatorChar + clazz.getSimpleName() + ".json"));
    }
}
