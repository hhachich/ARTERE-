package fr.hhachich.ArtereTest.service;

import fr.hhachich.ArtereTest.entity.Categorie;
import fr.hhachich.ArtereTest.entity.Produit;
import fr.hhachich.ArtereTest.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    @Transactional
    public Produit addProduit(Produit produit) throws Exception{
        return produitRepository.save(produit);
    }
    @Transactional
    public Produit updateProduit(Long id, Produit produit) throws Exception{
        Produit newProduit = produitRepository.findById(id).orElseThrow();
        try {
            newProduit.setNom(produit.getNom());
            newProduit.setPrix(produit.getPrix());
            newProduit.setQuantite(produit.getQuantite());
            newProduit.setCategories(produit.getCategories());
        }catch (Exception e){
            System.err.println(e);
        }
        return produitRepository.save(newProduit);
    }
    @Transactional
    public void deleteProduit(Long id) throws Exception{
        produitRepository.deleteById(id);
    }
}
