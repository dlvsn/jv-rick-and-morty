package mate.academy.rickandmorty.service;

import java.util.List;

public interface ClientApi<T> {
    T getRandomHero(int randomNumber);

    List<T> findHeroesByName(String heroName);
}
