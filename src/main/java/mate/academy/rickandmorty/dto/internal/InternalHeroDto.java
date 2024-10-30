package mate.academy.rickandmorty.dto.internal;

public record InternalHeroDto(Long id,
                              Long externalId,
                              String name,
                              String status,
                              String gender) {
}
