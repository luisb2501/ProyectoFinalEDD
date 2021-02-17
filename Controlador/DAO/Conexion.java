/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 *
 * @author ASUS
 */
public class Conexion {
    private String direccion;
    private XStream xtrStream; 
    
    /**
        * @desc Permite asignar donde se guardará el fichero
        * @param String direccion donde se guarda el fichero
    */
    public Conexion(String direccion) {
        this.direccion = direccion;
        xtrStream = new XStream(new JettisonMappedXmlDriver());
        xtrStream.setMode(XStream.NO_REFERENCES);
    }

    public String getDireccion() {
        return direccion;
    }

    public XStream getXtrStream() {
        return xtrStream;
    }
}
