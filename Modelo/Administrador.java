/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jonathan Javier
 */
public class Administrador extends Persona{
    private int codigoAdmin = (int)(Math.random()*10000);

    public int getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(int codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }
    
}
