package com.visionarycrofting.entity;

import javax.persistence.*;

@Entity
public class CommandeItems {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(unique = true)
    private String reference;

    private Float prix;

    private int quantity;

    @ManyToOne
    private Commande commande;

    @ManyToOne
    private Produit produit;

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

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "CommandeItems{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", prix=" + prix +
                ", quantity=" + quantity +
                ", commande=" + commande +
                ", produit=" + produit +
                '}';
    }
}
