package com.visionarycrofting.entity;

import javax.persistence.*;

@Entity
@Table
public class AppelOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String reference;
    @Enumerated(EnumType.STRING)
    private StatusAppelOffre statusAppelOffre;
    @ManyToOne
    Produit Produit;

    @ManyToOne
    Stock stock;

    public AppelOffre(Long id, String reference, StatusAppelOffre statusAppelOffre, Produit produit, Stock stock) {
        this.id = id;
        this.reference = reference;
        this.statusAppelOffre = statusAppelOffre;
        Produit = produit;
        this.stock = stock;
    }

    public AppelOffre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public StatusAppelOffre getStatusAppelOffre() {
        return statusAppelOffre;
    }

    public void setStatusAppelOffre(StatusAppelOffre statusAppelOffre) {
        this.statusAppelOffre = statusAppelOffre;
    }

    public Produit getProduit() {
        return Produit;
    }

    public void setProduit(Produit produit) {
        Produit = produit;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "AppelOffre{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", statusAppelOffre=" + statusAppelOffre +
                ", Produit=" Produit +
                ", stock=" + stock +
                '}';
    }
}
