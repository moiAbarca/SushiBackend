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
public class ResgistroPago {
    private int registroPagoId;
    private int tipoPagoId;
    private int pedidoCabeceraId;
    private String estadoPago;
    private int codigoAutorizacion;
    private int numeroCuotas;
    private int montoTotal;

    /**
     * @return the registroPagoId
     */
    public int getRegistroPagoId() {
        return registroPagoId;
    }

    /**
     * @param registroPagoId the registroPagoId to set
     */
    public void setRegistroPagoId(int registroPagoId) {
        this.registroPagoId = registroPagoId;
    }

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
     * @return the pedidoCabeceraId
     */
    public int getPedidoCabeceraId() {
        return pedidoCabeceraId;
    }

    /**
     * @param pedidoCabeceraId the pedidoCabeceraId to set
     */
    public void setPedidoCabeceraId(int pedidoCabeceraId) {
        this.pedidoCabeceraId = pedidoCabeceraId;
    }

    /**
     * @return the estadoPago
     */
    public String getEstadoPago() {
        return estadoPago;
    }

    /**
     * @param estadoPago the estadoPago to set
     */
    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    /**
     * @return the codigoAutorizacion
     */
    public int getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    /**
     * @param codigoAutorizacion the codigoAutorizacion to set
     */
    public void setCodigoAutorizacion(int codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    /**
     * @return the numeroCuotas
     */
    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    /**
     * @param numeroCuotas the numeroCuotas to set
     */
    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    /**
     * @return the montoTotal
     */
    public int getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
}
