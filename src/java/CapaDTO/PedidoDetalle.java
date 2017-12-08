/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

import java.sql.Date;
import java.sql.Time;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author moi
 */
@XmlRootElement(name = "PedidoDetalle")
@XmlAccessorType(XmlAccessType.FIELD)
public class PedidoDetalle {
    private int pedidoDetalleId;
    private int pedidoCabeceraId;
    private int productoId;
    private int cantidad;
    private String fechaPedidoDetalle;
    private String horaPedidoDetalle;

    /**
     * @return the pedidoDetalleId
     */
    public int getPedidoDetalleId() {
        return pedidoDetalleId;
    }

    /**
     * @param pedidoDetalleId the pedidoDetalleId to set
     */
    public void setPedidoDetalleId(int pedidoDetalleId) {
        this.pedidoDetalleId = pedidoDetalleId;
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
     * @return the productoId
     */
    public int getProductoId() {
        return productoId;
    }

    /**
     * @param productoId the productoId to set
     */
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fechaPedidoDetalle
     */
    
    public String getFechaPedidoDetalle() {
        return fechaPedidoDetalle;
    }

    /**
     * @param fechaPedidoDetalle the fechaPedidoDetalle to set
     */
    public void setFechaPedidoDetalle(String fechaPedidoDetalle) {
        this.fechaPedidoDetalle = fechaPedidoDetalle;
    }

    /**
     * @return the horaPedidoDetalle
     */
    public String getHoraPedidoDetalle() {
        return horaPedidoDetalle;
    }

    /**
     * @param horaPedidoDetalle the horaPedidoDetalle to set
     */
    public void setHoraPedidoDetalle(String horaPedidoDetalle) {
        this.horaPedidoDetalle = horaPedidoDetalle;
    }
}
