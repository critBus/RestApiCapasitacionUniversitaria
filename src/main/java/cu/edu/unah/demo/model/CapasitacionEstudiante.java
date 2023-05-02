/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.edu.unah.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rene2
 */
@Entity
@Table(name = "capasitacion_estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapasitacionEstudiante.findAll", query = "SELECT c FROM CapasitacionEstudiante c")
    , @NamedQuery(name = "CapasitacionEstudiante.findById", query = "SELECT c FROM CapasitacionEstudiante c WHERE c.id = :id")})
public class CapasitacionEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idcapasitacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Capasitacion idcapasitacion;
    @JoinColumn(name = "idestudiante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;

    public CapasitacionEstudiante() {
    }

    public CapasitacionEstudiante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Capasitacion getIdcapasitacion() {
        return idcapasitacion;
    }

    public void setIdcapasitacion(Capasitacion idcapasitacion) {
        this.idcapasitacion = idcapasitacion;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapasitacionEstudiante)) {
            return false;
        }
        CapasitacionEstudiante other = (CapasitacionEstudiante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CapasitacionEstudiante[ id=" + id + " ]";
    }
    
}
