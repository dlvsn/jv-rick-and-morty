package mate.academy.rickandmorty.repository;

import mate.academy.rickandmorty.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
