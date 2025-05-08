package de.dhbw.ravensburg.wp.mymoviedatabase.mapper;

import de.dhbw.ravensburg.wp.mymoviedatabase.dto.AwardDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AwardMapper {

    AwardDTO awardToAwardDTO(Award award);
    List<AwardDTO> awardsToAwardDTOs(List<Award> awards);

    Award awardDTOToAward(AwardDTO awardDTO);
    List<Award> awardDTOsToAwards(List<AwardDTO> awardDTOs);

}
