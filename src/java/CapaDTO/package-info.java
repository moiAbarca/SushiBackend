/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@XmlJavaTypeAdapters(  
 @XmlJavaTypeAdapter(value=TimestampAdapter.class,type=Timestamp.class))
package CapaDTO;
import java.sql.Timestamp;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import CapaDTO.TimestampAdapter;
