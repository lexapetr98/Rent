package com.lexapetr.rent.interfaces;

import com.lexapetr.rent.dto.*;
import com.lexapetr.rent.model.RenterModel;

import java.util.List;

public interface RenterService {
    public int create(RenterCreateDto renterCreateDto);
    List<RenterGetDto> readAll();
    RenterGetDto read(int id);
    void update(RenterUpdateDto renter, int id);
    RenterDeleteDto delete(int id);
    RenterGetDto patch(int id, RenterPatchDto renterPatchDto);
}
