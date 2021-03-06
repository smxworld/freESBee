package it.unibas.icar.freesbee.modello;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})

public class ServizioApplicativo implements Serializable{
    
    private long Id;
    private String nome;
    private String descrizione;
    private String connettore;
    private boolean mutuaAutenticazione;
    private List<PortaApplicativa> listaPorteApplicative;

    @Id 
    @GeneratedValue(strategy=GenerationType.TABLE)
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConnettore() {
        return connettore;
    }

    public void setConnettore(String connettore) {
        this.connettore = connettore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isMutuaAutenticazione() {
        return mutuaAutenticazione;
    }

    public void setMutuaAutenticazione(boolean mutuaAutenticazione) {
        this.mutuaAutenticazione = mutuaAutenticazione;
    }
    
    @XmlTransient()
    @OneToMany(mappedBy="servizioApplicativo", cascade=CascadeType.ALL)
    public List<PortaApplicativa> getListaPorteApplicative() {
        return listaPorteApplicative;
    }

    public void setListaPorteApplicative(List<PortaApplicativa> listaPorteApplicative) {
        this.listaPorteApplicative = listaPorteApplicative;
    }
}
