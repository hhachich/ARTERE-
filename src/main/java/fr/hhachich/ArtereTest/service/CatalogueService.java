package fr.hhachich.ArtereTest.service;

import fr.hhachich.ArtereTest.entity.Catalogue;
import fr.hhachich.ArtereTest.repository.CatalogueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {
    @Autowired
    private CatalogueRepository catalogueRepository;
    @Transactional
    public Catalogue addCatalogue(Catalogue catalogue) throws Exception{
        return catalogueRepository.save(catalogue);
    }

    public List<Catalogue> getAllCatalogue() {
        return catalogueRepository.findAll();
    }

    @Transactional
    public Catalogue updateCatalogue(Long id, Catalogue catalogue) throws Exception{
        Catalogue newCatalogue= catalogueRepository.findById(id).orElseThrow();
        try {
            newCatalogue.setNom(catalogue.getNom());
            newCatalogue.setCategories(catalogue.getCategories());
        }catch (Exception e){
            System.err.println(e);
        }
        return catalogueRepository.save(newCatalogue);
    }
    @Transactional
    public void deleteCatalogue(Long id) throws Exception{
        catalogueRepository.deleteById(id);
    }
}
