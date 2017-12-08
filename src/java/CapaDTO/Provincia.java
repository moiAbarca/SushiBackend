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
public class Provincia {
    private int provinciaId;
    private int regionId;
    private String provinciaNombre;

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
     * @return the regionId
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * @return the provinciaNombre
     */
    public String getProvinciaNombre() {
        return provinciaNombre;
    }

    /**
     * @param provinciaNombre the provinciaNombre to set
     */
    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }
}
