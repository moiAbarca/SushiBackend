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
public class Canal {
    private int canalId;
    private String nombreCanal;

    /**
     * @return the canalId
     */
    public int getCanalId() {
        return canalId;
    }

    /**
     * @param canalId the canalId to set
     */
    public void setCanalId(int canalId) {
        this.canalId = canalId;
    }

    /**
     * @return the nombreCanal
     */
    public String getNombreCanal() {
        return nombreCanal;
    }

    /**
     * @param nombreCanal the nombreCanal to set
     */
    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }
}
