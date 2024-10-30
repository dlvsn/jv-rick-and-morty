package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.internal.InternalHeroDto;

public interface RickAndMortyService {
    InternalHeroDto getRandomCharacter();

    List<InternalHeroDto> findByName(String name);
}
