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
public class Region {
    private int regionId;
    private String regionNombre;

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
     * @return the regionNombre
     */
    public String getRegionNombre() {
        return regionNombre;
    }

    /**
     * @param regionNombre the regionNombre to set
     */
    public void setRegionNombre(String regionNombre) {
        this.regionNombre = regionNombre;
    }
}
