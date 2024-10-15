package fr.hhachich.ArtereTest.repository;

import fr.hhachich.ArtereTest.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue,Long> {
}
