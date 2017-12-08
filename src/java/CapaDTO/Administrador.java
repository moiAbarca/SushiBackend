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
public class Administrador {
    private int administradorId;
    private String nombreAdmin;
    private String apellidoAdmin;
    private String corrreoAdmin;
    private String telefonoAdmin;
    private int usuarioId;

    /**
     * @return the administradorId
     */
    public int getAdministradorId() {
        return administradorId;
    }

    /**
     * @param administradorId the administradorId to set
     */
    public void setAdministradorId(int administradorId) {
        this.administradorId = administradorId;
    }

    /**
     * @return the nombreAdmin
     */
    public String getNombreAdmin() {
        return nombreAdmin;
    }

    /**
     * @param nombreAdmin the nombreAdmin to set
     */
    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    /**
     * @return the apellidoAdmin
     */
    public String getApellidoAdmin() {
        return apellidoAdmin;
    }

    /**
     * @param apellidoAdmin the apellidoAdmin to set
     */
    public void setApellidoAdmin(String apellidoAdmin) {
        this.apellidoAdmin = apellidoAdmin;
    }

    /**
     * @return the corrreoAdmin
     */
    public String getCorrreoAdmin() {
        return corrreoAdmin;
    }

    /**
     * @param corrreoAdmin the corrreoAdmin to set
     */
    public void setCorrreoAdmin(String corrreoAdmin) {
        this.corrreoAdmin = corrreoAdmin;
    }

    /**
     * @return the telefonoAdmin
     */
    public String getTelefonoAdmin() {
        return telefonoAdmin;
    }

    /**
     * @param telefonoAdmin the telefonoAdmin to set
     */
    public void setTelefonoAdmin(String telefonoAdmin) {
        this.telefonoAdmin = telefonoAdmin;
    }

    /**
     * @return the usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
}
