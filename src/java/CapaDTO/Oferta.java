/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/**
 *
 * @author moi
 */

public class Oferta {
    private int ofertaId;
    private double porcentajeOferta;
    private String fechaInicio;
    private String fechaTermino;

    /**
     * @return the ofertaId
     */
    public int getOfertaId() {
        return ofertaId;
    }

    /**
     * @param ofertaId the ofertaId to set
     */
    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    /**
     * @return the porcentajeOferta
     */
    public double getPorcentajeOferta() {
        return porcentajeOferta;
    }

    /**
     * @param porcentajeOferta the porcentajeOferta to set
     */
    public void setPorcentajeOferta(double porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }

    /**
     * @return the fechaInicio
     */
    
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaTermino
     */
    
    public String getFechaTermino() {
        return fechaTermino;
    }

    /**
     * @param fechaTermino the fechaTermino to set
     */
    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
}
