package mate.academy.rickandmorty.service;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.ExternalHeroDto;
import mate.academy.rickandmorty.dto.internal.InternalHeroDto;
import mate.academy.rickandmorty.mapper.HeroMapper;
import mate.academy.rickandmorty.model.Hero;
import mate.academy.rickandmorty.repository.HeroRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RickAndMortyServiceImpl implements RickAndMortyService {
    private static final int API_COUNT_HEROES = 800;
    private final ClientApi<ExternalHeroDto> rickAndMortyClient;
    private final HeroMapper heroMapper;
    private final HeroRepository heroRepository;

    @Override
    public InternalHeroDto getRandomCharacter() {
        ExternalHeroDto randomHero = rickAndMortyClient
                .getRandomHero(new Random().nextInt(API_COUNT_HEROES));
        Hero entity = heroMapper.toEntity(randomHero);
        return heroMapper.toDto(heroRepository.save(entity));
    }

    @Override
    public List<InternalHeroDto> findByName(String name) {
        return rickAndMortyClient
                .findHeroesByName(name).stream()
                .map(e -> {
                    Hero entity = heroMapper.toEntity(e);
                    return heroMapper.toDto(heroRepository.save(entity));
                })
                .toList();
    }
}
