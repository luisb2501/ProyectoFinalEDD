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
public class Plan {
    private String nombrePlan;
    private Double costoPlan;
    private Double minutosNacional;
    private Double minutosExterior;
    private Double megas;

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public Double getCostoPlan() {
        return costoPlan;
    }

    public void setCostoPlan(Double costoPlan) {
        this.costoPlan = costoPlan;
    }

    public Double getMinutosNacional() {
        return minutosNacional;
    }

    public void setMinutosNacional(Double minutosNacional) {
        this.minutosNacional = minutosNacional;
    }

    public Double getMinutosExterior() {
        return minutosExterior;
    }

    public void setMinutosExterior(Double minutosExterior) {
        this.minutosExterior = minutosExterior;
    }

    public Double getMegas() {
        return megas;
    }

    public void setMegas(Double megas) {
        this.megas = megas;
    }
    
    
    
}
