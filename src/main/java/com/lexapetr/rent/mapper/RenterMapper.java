package com.lexapetr.rent.mapper;

import com.lexapetr.rent.dto.RenterCreateDto;
import com.lexapetr.rent.dto.RenterDeleteDto;
import com.lexapetr.rent.dto.RenterGetDto;
import com.lexapetr.rent.dto.RenterUpdateDto;
import com.lexapetr.rent.entity.Renter;
import com.lexapetr.rent.model.RenterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RenterMapper {
    RenterModel toModel(Renter renter);

    RenterModel toModel(RenterCreateDto renterCreateDto);

    RenterModel toModel(RenterUpdateDto renterUpdateDto);

    Renter toEntity(RenterModel renterModel);

    @Mapping(target = "renterid", ignore = true)
    Renter toEntity(@MappingTarget Renter renterEntity, RenterModel renterModel);

    RenterDeleteDto toDeleteDto(RenterModel renterModel);

    RenterGetDto toGetDto(RenterModel renterModel);
}
