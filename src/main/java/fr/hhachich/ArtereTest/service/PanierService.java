package fr.hhachich.ArtereTest.service;

import fr.hhachich.ArtereTest.entity.Panier;
import fr.hhachich.ArtereTest.entity.Produit;
import fr.hhachich.ArtereTest.repository.PanierRepositoy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanierService {
    @Autowired
    private PanierRepositoy panierRepositoy;

    @Transactional
    public Panier CreatePanier(Panier panier) throws Exception{
        // a faire creation du totale
        return panierRepositoy.save(panier);
    }
    @Transactional
    public Panier addProduitPanier(Long idPanier, Long idProduit) throws Exception{
        // a faire
        return null;
    }

    @Transactional
    public void deleteProduitPanier(Long idPanier, Long idProduit) throws Exception{
        // a faire
    }
}
