package model.doenca;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "doenca")
public class Doenca {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "sintomas")
    private String sintomas;

    public Doenca() { }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setNome(String nome) {
        this.name = name;
    }

    public String getSintomas() {
        return this.sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }    
}