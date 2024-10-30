package mate.academy.rickandmorty.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.InternalHeroDto;
import mate.academy.rickandmorty.service.RickAndMortyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/character")
public class RickAndMortyController {
    private final RickAndMortyService rickAndMortyService;

    @GetMapping("/get")
    public InternalHeroDto rickAndMorty() {
        return rickAndMortyService.getRandomCharacter();
    }

    @GetMapping("/find")
    List<InternalHeroDto> heroesByName(String name) {
        return rickAndMortyService.findByName(name);
    }
}
