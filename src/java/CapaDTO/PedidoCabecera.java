/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

import java.sql.Timestamp;
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
@XmlRootElement(name = "PedidoCabecera")
@XmlAccessorType(XmlAccessType.FIELD)
public class PedidoCabecera {
    private int pedidoCabeceraId;
    private int establecimientoId;    
    private int clienteId;
    private String fechaPedido;
    private String horaPedido;
    private String estadoPedido;

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
     * @return the establecimientoId
     */
    public int getEstablecimientoId() {
        return establecimientoId;
    }

    /**
     * @param establecimientoId the establecimientoId to set
     */
    public void setEstablecimientoId(int establecimientoId) {
        this.establecimientoId = establecimientoId;
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
     * @return the fechaPedido
     */
    
    public String getFechaPedido() {
        return fechaPedido;
    }

    /**
     * @param fechaPedido the fechaPedido to set
     */
    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    /**
     * @return the horaPedido
     */
    
    public String getHoraPedido() {
        return horaPedido;
    }

    /**
     * @param horaPedido the horaPedido to set
     */
    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    /**
     * @return the estadoPedido
     */
    public String getEstadoPedido() {
        return estadoPedido;
    }

    /**
     * @param estadoPedido the estadoPedido to set
     */
    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
