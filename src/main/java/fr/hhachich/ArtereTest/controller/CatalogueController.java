package fr.hhachich.ArtereTest.controller;

import fr.hhachich.ArtereTest.entity.Catalogue;
import fr.hhachich.ArtereTest.entity.Categorie;
import fr.hhachich.ArtereTest.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
    @Autowired
    private CatalogueService catalogueService;

    @PostMapping("/add")
    public Catalogue addCatalogue(@RequestBody Catalogue catalogue) throws Exception {
        return catalogueService.addCatalogue(catalogue);
    }
    @PutMapping("/update/{id}")
    public Catalogue updateCatalogue(@PathVariable Long id,@RequestBody Catalogue catalogue) throws Exception {
        return catalogueService.updateCatalogue(id,catalogue);
    }
    @DeleteMapping("/{id}")
    public void deleteCatalogue(@PathVariable Long id) throws Exception {
        catalogueService.deleteCatalogue(id);
    }
}
