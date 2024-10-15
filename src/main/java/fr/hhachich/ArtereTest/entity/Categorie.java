package fr.hhachich.ArtereTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    //une relation parent-enfant entre categorie parent et sous categorie
    @ManyToOne
    @JoinColumn(name = "categorieParent_id")
    private Categorie categorieParent;

    @OneToMany(mappedBy = "categorieParent")
    private List<Categorie> categorieEnfants;

    // plusieur categorie appartient a un catalogue
    @ManyToOne
    @JoinColumn(name = "catalogue_id")
    private Catalogue catalogue;

    @ManyToMany
    @JoinTable(
            name = "categorie_produit",
            joinColumns = @JoinColumn(name = "categorie_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits;
}
