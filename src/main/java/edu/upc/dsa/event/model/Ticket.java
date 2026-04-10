package edu.upc.dsa.event.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entrada")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {

    private String nombre;
    private String apellido;

    @XmlElement(name = "correo_electronico")
    private String correoElectronico;

    private String entrepa;
    private String hash;

    @XmlElement(name = "numero_local")
    private int numeroLocal;

    private boolean consumed;

    @XmlElement(name = "consumed_at")
    private String consumedAt;

    public Ticket() {
    }

    public Ticket(String nombre, String apellido, String correoElectronico, String entrepa, String hash, int numeroLocal, boolean consumed) {
        this(nombre, apellido, correoElectronico, entrepa, hash, numeroLocal, consumed, null);
    }

    public Ticket(String nombre, String apellido, String correoElectronico, String entrepa, String hash, int numeroLocal, boolean consumed, String consumedAt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.entrepa = entrepa;
        this.hash = hash;
        this.numeroLocal = numeroLocal;
        this.consumed = consumed;
        this.consumedAt = consumedAt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEntrepa() {
        return entrepa;
    }

    public void setEntrepa(String entrepa) {
        this.entrepa = entrepa;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public String getConsumedAt() {
        return consumedAt;
    }

    public void setConsumedAt(String consumedAt) {
        this.consumedAt = consumedAt;
    }
}



