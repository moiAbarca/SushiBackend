/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasesinterface;

import CapaDTO.Region;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author moi
 */
public interface RegionDao {
    public List<Region> obtenerRegion() throws SQLException;
    public void agregarRegion(Region region) throws SQLException;
    public void modificarRegion(Region region) throws SQLException;
    public void eliminarRegion(Integer id) throws SQLException;
    public Region buscarRegion(Integer id) throws SQLException;
}
