package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.dto.external.ExternalHeroDto;
import mate.academy.rickandmorty.dto.internal.InternalHeroDto;
import mate.academy.rickandmorty.model.Hero;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface HeroMapper {

    InternalHeroDto toDto(Hero hero);

    Hero toEntity(ExternalHeroDto dto);
}
