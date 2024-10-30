package mate.academy.rickandmorty.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ExternalHeroResponseDto(
        @JsonProperty("results")
        List<ExternalHeroDto> result) {
}
