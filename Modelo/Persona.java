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
public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String numeroCelular;
    private CuentaCliente cuenta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public CuentaCliente getCuenta() {
        if (cuenta == null) {
            cuenta = new CuentaCliente();
        }
        return cuenta;
    }

    public void setCuenta(CuentaCliente cuenta) {
        this.cuenta = cuenta;
    }

    public Persona(String nombre, String apellido, String cedula, String numeroCelular, CuentaCliente cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.numeroCelular = numeroCelular;
        this.cuenta = cuenta;
    }

    public Persona() {
    }
    
}
