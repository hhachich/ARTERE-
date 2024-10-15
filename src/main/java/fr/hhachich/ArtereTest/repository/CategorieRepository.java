package fr.hhachich.ArtereTest.repository;

import fr.hhachich.ArtereTest.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
