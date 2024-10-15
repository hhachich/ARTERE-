package fr.hhachich.ArtereTest.repository;

import fr.hhachich.ArtereTest.entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepositoy extends JpaRepository<Panier,Long> {
}
