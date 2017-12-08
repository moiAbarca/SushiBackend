/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

/**
 *
 * @author moi
 */
public class Seguimiento {

    
    private int seguimientoId;
    
    private String evento;
    private String  componente;
    private int clienteId;

    /**
     * @return the seguimientoId
     */
    public int getSeguimientoId() {
        return seguimientoId;
    }

    /**
     * @param seguimientoId the seguimientoId to set
     */
    public void setSeguimientoId(int seguimientoId) {
        this.seguimientoId = seguimientoId;
    }


    /**
     * @return the clienteId
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    /**
     * @return the evento
     */
    public String getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * @return the componente
     */
    public String getComponente() {
        return componente;
    }

    /**
     * @param componente the componente to set
     */
    public void setComponente(String componente) {
        this.componente = componente;
    }
}
