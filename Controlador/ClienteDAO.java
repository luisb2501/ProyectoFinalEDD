/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.AdaptadorDAO;
import Controlador.DAO.Conexion;
import Controlador.listaSimple.ListaSimple;
import Modelo.Persona;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Javier
 */
public class ClienteDAO extends AdaptadorDAO{
    public Persona cliente;
    
    /**
        * @desc Contructor de la clase, que permite definir le direccion del fichero
        * @param string direccion - direccion del fichero
    */
    public ClienteDAO(String direccion) {
        super(new Conexion(direccion), Persona.class);
    }

    public Persona getCliente() {
        if (cliente == null) {
            cliente = new Persona();
        }
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
    /**
        * @desc Permite guardar el objeto Cliente dentro de un fichero
        * @return boolean - para confirmar si el objeto se guardó correctamente
    */
    public boolean guardar(){
        try {
//            this.getCliente().setCedula(String.valueOf(listar().tamano() + 1));
//            this.getPersona().setEstadoPersona(true);
            this.guardar(this.getCliente());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
            return false;
        }
    }
    
    /**
        * @desc Permite editar uno de los objetos almacenados en el archivo
        * @param String cedula del administrador a editar
        * @param Object objeto para editar
        * @return boolean - para confirmar si el objeto se editócorrectamente
    */
    public Boolean editar(String idPersona, Object dato) {
        ListaSimple lista = listar();
        for (int i = 0; i < lista.tamano(); i++) {
            Persona aux = (Persona) lista.obtenerPorPosicion(i);
            if (aux.getCedula() == idPersona) {
                lista.editarPosicion(dato, i);
                break;
            }
        }
        try {
            this.modificar(lista);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
