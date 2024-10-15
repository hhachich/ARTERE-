package fr.hhachich.ArtereTest.service;

import fr.hhachich.ArtereTest.entity.Catalogue;
import fr.hhachich.ArtereTest.entity.Categorie;
import fr.hhachich.ArtereTest.entity.Produit;
import fr.hhachich.ArtereTest.repository.CategorieRepository;
import fr.hhachich.ArtereTest.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ProduitRepository produitRepository;

    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }
    @Transactional
    public Categorie addCategorie(Categorie categorie) throws Exception{
        return categorieRepository.save(categorie);
    }
    @Transactional
    public Categorie updateCategorie(Long id, Categorie categorie) throws Exception{
        // Categorie newcategorie= categorieRepository.findById(categorie.getId()).orElseThrow();
        Categorie newcategorie= categorieRepository.findById(id).orElseThrow();
        try {
            newcategorie.setNom(categorie.getNom());
            newcategorie.setDescription(categorie.getDescription());
            newcategorie.setCategorieParent(categorie.getCategorieParent());
            newcategorie.setCategorieEnfants(categorie.getCategorieEnfants());
            newcategorie.setProduits(categorie.getProduits());
            newcategorie.setCatalogue(categorie.getCatalogue());
        }catch (Exception e){
            System.err.println(e);
        }

        // a completer
        return categorieRepository.save(newcategorie);
    }
    @Transactional
    public void deleteCategorie(Long id) throws Exception{
        categorieRepository.deleteById(id);
    }
    @Transactional
    public void  lierProduitCategorie(Long produitId, Long categorieId){
        Produit produit = produitRepository.findById(produitId).orElseThrow();
        Categorie categorie=categorieRepository.findById(categorieId).orElseThrow();
        categorie.getProduits().add(produit);
        categorieRepository.save(categorie);
    }
    @Transactional
    public void  delierProduitCategorie(Long produitId, Long categorieId){
        Produit produit = produitRepository.findById(produitId).orElseThrow();
        Categorie categorie=categorieRepository.findById(categorieId).orElseThrow();
        categorie.getProduits().remove(produit);
        categorieRepository.save(categorie);
    }
}
