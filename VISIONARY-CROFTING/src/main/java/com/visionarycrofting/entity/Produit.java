package com.visionarycrofting.entity;

import javax.persistence.*;


@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String reference;
    private String nom;
    private String prix_initial;
    private String description;
    private Category category;
    private int quantity;

    public Produit() { }

    public Produit( String reference, String nom, String prix_initial, String description, Category category, int quantity) {

        this.reference = reference;
        this.nom = nom;
        this.prix_initial = prix_initial;
        this.description = description;
        this.category = category;
        this.quantity = quantity;

    }

    public void setId(Long id) { this.id = id; }
    public void setReference(String reference) { this.reference = reference; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrix_initial(String prix_initial) { this.prix_initial = prix_initial; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(Category category) { this.category = category; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Long getId() { return id; }
    public String getReference() { return reference; }
    public String getNom() { return nom; }
    public String getPrix_initial() { return prix_initial; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public int getQuantity() { return quantity; }

}