package com.visionarycrofting.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(unique = true)
    private String reference;

    private LocalDate date;

    private Float prixTotal;

    private StatusCommande status ;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<CommandeItems> commandeItems = new ArrayList<>();

    @ManyToOne
    private Client client ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public StatusCommande getStatus() {
        return status;
    }

    public void setStatus(StatusCommande status) {
        this.status = status;
    }

    public List<CommandeItems> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItems> commandeItems) {
        this.commandeItems = commandeItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", date=" + date +
                ", prixTotal=" + prixTotal +
                ", status=" + status +
                ", commadeItems=" + commandeItems +
                '}';
    }
}
