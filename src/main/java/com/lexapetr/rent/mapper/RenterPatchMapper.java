package com.lexapetr.rent.mapper;

import com.lexapetr.rent.dto.RenterPatchDto;
import com.lexapetr.rent.entity.Renter;
import com.lexapetr.rent.model.RenterModel;
import partial.update.mapper.PartialUpdateMapper;

public interface RenterPatchMapper extends PartialUpdateMapper {
    RenterModel toModel(RenterPatchDto renterPatchDto);
    void toEntity(Renter renterEntity, RenterModel renterModel);
}
