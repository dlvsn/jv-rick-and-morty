package mate.academy.rickandmorty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.InternalHeroDto;
import mate.academy.rickandmorty.service.RickAndMortyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Rick&MortyApi", description = "")
@RequiredArgsConstructor
@RestController
@RequestMapping("/character")
public class RickAndMortyController {
    private final RickAndMortyService rickAndMortyService;

    @Operation(summary = "Add random hero", description = """
            The request randomly generates a wiki about one character in 
            the universe the animated series Rick & Morty.""")
    @GetMapping("/get")
    public InternalHeroDto rickAndMorty() {
        return rickAndMortyService.getRandomCharacter();
    }

    @Operation(summary = "Find hero by name", description = """
            The request takes a string as an argument, and returns a list of all characters 
            whose name contains the search string. During the application start, 
            the web application downloads data from a third-party service 
            to the internal database.""")
    @GetMapping("/find")
    List<InternalHeroDto> heroesByName(String name) {
        return rickAndMortyService.findByName(name);
    }
}
