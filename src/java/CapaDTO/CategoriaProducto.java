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
public class CategoriaProducto {
    private int categoriaProductoId;
    private String nombreCategoria;

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
     * @return the nombreCategoria
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * @param nombreCategoria the nombreCategoria to set
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
