package fr.hhachich.ArtereTest.controller;

import fr.hhachich.ArtereTest.entity.Categorie;
import fr.hhachich.ArtereTest.entity.Produit;
import fr.hhachich.ArtereTest.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping("/add")
    public Categorie addCategorie(@RequestBody Categorie categorie) throws Exception {
        return categorieService.addCategorie(categorie);
    }
    @PutMapping("/update/{id}")
    public Categorie updateCategorie(@PathVariable Long id,@RequestBody Categorie categorie) throws Exception {
        return categorieService.updateCategorie(id,categorie);
    }
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) throws Exception {
        categorieService.deleteCategorie(id);
    }
    @PutMapping("/lierProduitCategorie/produitId/{produitId}/categorieId/{categorieId}")
    public void lierProduitCategorie(@PathVariable Long produitId,@PathVariable Long categorieId) throws Exception {
        categorieService.lierProduitCategorie(produitId,categorieId);
    }
    @PutMapping("/delierProduitCategorie/produitId/{produitId}/categorieId/{categorieId}")
    public void delierProduitCategorie(@PathVariable Long produitId,@PathVariable Long categorieId) throws Exception {
        categorieService.delierProduitCategorie(produitId,categorieId);
    }
}
