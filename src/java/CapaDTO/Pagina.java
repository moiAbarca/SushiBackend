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
public class Pagina {
    private int paginaId;
    private String pagina;
    private String urlPagina;

    /**
     * @return the paginaId
     */
    public int getPaginaId() {
        return paginaId;
    }

    /**
     * @param paginaId the paginaId to set
     */
    public void setPaginaId(int paginaId) {
        this.paginaId = paginaId;
    }

    /**
     * @return the pagina
     */
    public String getPagina() {
        return pagina;
    }

    /**
     * @param pagina the pagina to set
     */
    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    /**
     * @return the urlPagina
     */
    public String getUrlPagina() {
        return urlPagina;
    }

    /**
     * @param urlPagina the urlPagina to set
     */
    public void setUrlPagina(String urlPagina) {
        this.urlPagina = urlPagina;
    }
}
