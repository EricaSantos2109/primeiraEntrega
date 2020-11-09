package model.epi;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "epi")
public class Epi {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // Gera o id automaticamente
    private int id;
    @Column(name = "coleta")
    private String coleta;
    @Column(name = "associada")
    private String associada;

    public Epi() { }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColeta() {
        return this.coleta;
    }

    public void setColeta(String coleta) {
        this.coleta = coleta;
    }

    public String getAssociada() {
        return this.associada;
    }

    public void setAssociada(String associada) {
        this.associada = associada;
    }    
}