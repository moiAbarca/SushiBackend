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
public class Acceso {
    private int accesoId;
    private int paginaId;
    private int perfilId;

    /**
     * @return the accesoId
     */
    public int getAccesoId() {
        return accesoId;
    }

    /**
     * @param accesoId the accesoId to set
     */
    public void setAccesoId(int accesoId) {
        this.accesoId = accesoId;
    }

    /**
     * @return the paginaId
     */
    public int getPaginaId() {
        return paginaId;
    }

    /**
     * @param paginaId the paginaId to set
     */
    public void setPaginaId(int paginaId) {
        this.paginaId = paginaId;
    }

    /**
     * @return the perfilId
     */
    public int getPerfilId() {
        return perfilId;
    }

    /**
     * @param perfilId the perfilId to set
     */
    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }
}
