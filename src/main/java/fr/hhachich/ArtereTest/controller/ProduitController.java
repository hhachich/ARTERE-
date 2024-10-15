package fr.hhachich.ArtereTest.controller;

import fr.hhachich.ArtereTest.entity.Produit;
import fr.hhachich.ArtereTest.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @PostMapping("/add")
    public Produit addProduit(@RequestBody Produit produit) throws Exception {
        return produitService.addProduit(produit);
    }
    @PutMapping("/update/{id}")
    public Produit updateProduit(@PathVariable Long id,@RequestBody Produit produit) throws Exception {
        return produitService.updateProduit(id,produit);
    }
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) throws Exception {
        produitService.deleteProduit(id);
    }
}
