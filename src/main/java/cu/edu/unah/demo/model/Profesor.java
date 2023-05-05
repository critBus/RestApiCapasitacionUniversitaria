/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.edu.unah.demo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rene2
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findById", query = "SELECT p FROM Profesor p WHERE p.id = :id")
    , @NamedQuery(name = "Profesor.findByEspecialidad", query = "SELECT p FROM Profesor p WHERE p.especialidad = :especialidad")
    , @NamedQuery(name = "Profesor.findByFacultad", query = "SELECT p FROM Profesor p WHERE p.facultad = :facultad")
    , @NamedQuery(name = "Profesor.findByCarrera", query = "SELECT p FROM Profesor p WHERE p.carrera = :carrera")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "especialidad")
    private String especialidad;
    @Basic(optional = false)
    @Column(name = "facultad")
    private String facultad;
    @Basic(optional = false)
    @Column(name = "carrera")
    private String carrera;
    @JoinColumn(name = "iduniversitario", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Universitario iduniversitario;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
//    private List<CapasitacionProfesor> capasitacionProfesorList;

    public Profesor() {
    }

    public Profesor(Integer id) {
        this.id = id;
    }

    public Profesor(Integer id, String especialidad, String facultad, String carrera) {
        this.id = id;
        this.especialidad = especialidad;
        this.facultad = facultad;
        this.carrera = carrera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Universitario getIduniversitario() {
        return iduniversitario;
    }

    public void setIduniversitario(Universitario iduniversitario) {
        this.iduniversitario = iduniversitario;
    }

//    @XmlTransient
//    public List<CapasitacionProfesor> getCapasitacionProfesorList() {
//        return capasitacionProfesorList;
//    }
//
//    public void setCapasitacionProfesorList(List<CapasitacionProfesor> capasitacionProfesorList) {
//        this.capasitacionProfesorList = capasitacionProfesorList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Profesor[ id=" + id + " ]";
    }
    
}
