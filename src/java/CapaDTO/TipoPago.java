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
public class TipoPago {
    private int tipoPagoId;
    private String nombreTipoPago;

    /**
     * @return the tipoPagoId
     */
    public int getTipoPagoId() {
        return tipoPagoId;
    }

    /**
     * @param tipoPagoId the tipoPagoId to set
     */
    public void setTipoPagoId(int tipoPagoId) {
        this.tipoPagoId = tipoPagoId;
    }

    /**
     * @return the nombreTipoPago
     */
    public String getNombreTipoPago() {
        return nombreTipoPago;
    }

    /**
     * @param nombreTipoPago the nombreTipoPago to set
     */
    public void setNombreTipoPago(String nombreTipoPago) {
        this.nombreTipoPago = nombreTipoPago;
    }
}
