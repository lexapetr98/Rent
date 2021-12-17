package com.lexapetr.rent.services;

import com.lexapetr.rent.dto.*;
import com.lexapetr.rent.entity.Renter;
import com.lexapetr.rent.mapper.RenterPatchMapper;
import com.lexapetr.rent.interfaces.RenterRepository;
import com.lexapetr.rent.interfaces.RenterService;
import com.lexapetr.rent.mapper.RenterMapper;
import com.lexapetr.rent.model.RenterModel;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
@Service
@Transactional
public class RenterServiceImpl implements RenterService {
    private final RenterRepository renterRepository;
    private final RenterMapper renterMapper;
    private final RenterPatchMapper renterPatchMapper;

    @Transactional
    @Override
    public int create(RenterCreateDto renterCreateDto) {
       RenterModel renterModel = renterMapper.toModel(renterCreateDto);
       Renter renter = renterRepository.save(renterMapper.toEntity(renterModel));
       return renter.getRenterID();
    }

    @Override
    public List<RenterGetDto> readAll() {
        return StreamSupport.stream(renterRepository.findAll().spliterator(),false).map(renterMapper::toModel).map(renterMapper::toGetDto).collect(Collectors.toList());
    }

    @Override
    public RenterGetDto read(int id) {
        return renterRepository.findById(id).map(renterMapper::toModel).map(renterMapper::toGetDto).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    @Override
    public void update(RenterUpdateDto renter, int id) {
        Renter renterEntity = renterRepository.findById(id).map(entity -> renterMapper.toEntity(entity, renterMapper.toModel(renter))).orElseThrow(EntityNotFoundException::new);
        renterRepository.save(renterEntity);
    }

    @Transactional
    @Override
    public RenterDeleteDto delete(int id) {
        RenterDeleteDto renterDeleteDto = renterRepository.findById(id).map(renterMapper::toModel).map(renterMapper::toDeleteDto).orElseThrow(EntityNotFoundException::new);
        renterRepository.deleteById(id);
        return renterDeleteDto;
    }

    @Transactional
    @Override
    public RenterGetDto patch(int id, RenterPatchDto renterPatchDto){
        Renter renterEntity = renterRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        RenterModel renterModel = renterPatchMapper.toModel(renterPatchDto);
        renterPatchMapper.toEntity(renterEntity, renterModel);
        return renterMapper.toGetDto(renterMapper.toModel(renterRepository.save(renterEntity)));
    }
}
