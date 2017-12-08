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
public class Producto {



    
    private int productoId;
    private int categoriaProductoId;
    private String nombreProducto;
    private int porcionesProdcuto;
    private int precioProducto;
    private String descripcionProducto;
    private String imagenProdcuto;
    private boolean disponibilidadProducto;

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
     * @return the categoriaProductoId
     */
    public int getCategoriaProductoId() {
        return categoriaProductoId;
    }

    /**
     * @param categoriaProductoId the categoriaProductoId to set
     */
    public void setCategoriaProductoId(int categoriaProductoId) {
        this.categoriaProductoId = categoriaProductoId;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the porcionesProdcuto
     */
    public int getPorcionesProdcuto() {
        return porcionesProdcuto;
    }

    /**
     * @param porcionesProdcuto the porcionesProdcuto to set
     */
    public void setPorcionesProdcuto(int porcionesProdcuto) {
        this.porcionesProdcuto = porcionesProdcuto;
    }

    /**
     * @return the precioProducto
     */
    public int getPrecioProducto() {
        return precioProducto;
    }

    /**
     * @param precioProducto the precioProducto to set
     */
    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    /**
     * @return the descripcionProducto
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * @param descripcionProducto the descripcionProducto to set
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    /**
     * @return the imagenProdcuto
     */
    public String getImagenProdcuto() {
        return imagenProdcuto;
    }

    /**
     * @param imagenProdcuto the imagenProdcuto to set
     */
    public void setImagenProdcuto(String imagenProdcuto) {
        this.imagenProdcuto = imagenProdcuto;
    }
        /**
     * @return the disponibilidadProducto
     */
    public boolean isDisponibilidadProducto() {
        return disponibilidadProducto;
    }

    /**
     * @param disponibilidadProducto the disponibilidadProducto to set
     */
    public void setDisponibilidadProducto(boolean disponibilidadProducto) {
        this.disponibilidadProducto = disponibilidadProducto;
    }

}
