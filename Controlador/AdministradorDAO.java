/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.DAO.AdaptadorDAO;
import Controlador.DAO.Conexion;
import Controlador.listaSimple.ListaSimple;
import Modelo.Administrador;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Javier
 */
public class AdministradorDAO extends AdaptadorDAO{
    public Administrador admin;
    
    /**
        * @desc Contructor de la clase, que permite definir le direccion del fichero
        * @param string direccion - direccion del fichero
    */
    public AdministradorDAO(String direccion) {
        super(new Conexion(direccion), Administrador.class);
    }

    public Administrador getAdmin() {
        if (admin == null) {
            admin = new Administrador();
        }
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    
    /**
        * @desc Permite guardar el objeto Administrador dentro de un fichero
        * @return boolean - para confirmar si el objetos se guardó correctamente
    */
    public boolean guardar(){
        try {
            this.getAdmin().setCedula(String.valueOf(listar().tamano() + 1));
//            this.getPersona().setEstadoPersona(true);
            this.guardar(this.getAdmin());
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
    public Boolean editar(String cedula, Object dato) {
        ListaSimple lista = listar();
        for (int i = 0; i < lista.tamano(); i++) {
            Administrador aux = (Administrador) lista.obtenerPorPosicion(i);
            if (aux.getCedula() == cedula) {
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
