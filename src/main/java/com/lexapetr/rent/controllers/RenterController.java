package com.lexapetr.rent.controllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lexapetr.rent.dto.*;
import com.lexapetr.rent.interfaces.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/renters")
public class RenterController {
    private final RenterService renterService;

    @Autowired
    public RenterController(RenterService renterService){
        this.renterService = renterService;
    }

    @PostMapping
    public int create(@RequestBody RenterCreateDto renter){
        return renterService.create(renter);
    }

    @GetMapping
    public List<RenterGetDto> readAll(){
        return renterService.readAll();
    }

    @GetMapping(value = "/{id}")
    public RenterGetDto read (@PathVariable(name = "id") int id){
        return renterService.read(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") int id, @RequestBody RenterUpdateDto renter){
        renterService.update(renter, id);
    }

    @DeleteMapping(value = "{id}")
    public RenterDeleteDto delete(@PathVariable(name = "id") int id){
        return renterService.delete(id);
    }

    @PatchMapping(path = "{id}")
    @JsonDeserialize
    public RenterGetDto patch(@PathVariable int id, @RequestBody RenterPatchDto renterPatchDto) {
        return renterService.patch(id, renterPatchDto);
    }
}
