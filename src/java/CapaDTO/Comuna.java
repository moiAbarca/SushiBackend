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
public class Comuna {
    private int comunaId;
    private int provinciaId;
    private String comunaNombre;

    /**
     * @return the comunaId
     */
    public int getComunaId() {
        return comunaId;
    }

    /**
     * @param comunaId the comunaId to set
     */
    public void setComunaId(int comunaId) {
        this.comunaId = comunaId;
    }

    /**
     * @return the provinciaId
     */
    public int getProvinciaId() {
        return provinciaId;
    }

    /**
     * @param provinciaId the provinciaId to set
     */
    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }

    /**
     * @return the comunaNombre
     */
    public String getComunaNombre() {
        return comunaNombre;
    }

    /**
     * @param comunaNombre the comunaNombre to set
     */
    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }
}
