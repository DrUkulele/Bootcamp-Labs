package com.example.CarDealershipAPI.controllers;

import com.example.CarDealershipAPI.models.dto.CreateVehicleDTO;
import com.example.CarDealershipAPI.models.dto.UpdateVehicleDTO;
import com.example.CarDealershipAPI.models.dto.VehicleDTO;
import com.example.CarDealershipAPI.models.params.VehicleSearchParams;
import com.example.CarDealershipAPI.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CarDealership/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getVehicles(){
        var vehicles = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{vin}")
    public ResponseEntity<VehicleDTO> getVehicleByVin(@PathVariable Integer vin){
        return new ResponseEntity<>(vehicleService.getVehicleByVin(vin), HttpStatus.OK);
    }

    @DeleteMapping("/{vin}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Integer vin){
        vehicleService.deleteVehicle(vin);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@Valid @RequestBody CreateVehicleDTO dto){
        var vehicle = vehicleService.createVehicle(dto);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @PutMapping("/{vin}")
    public ResponseEntity<VehicleDTO> updateVehicle(@Valid @RequestBody UpdateVehicleDTO dto, @PathVariable Integer vin){
        var vehicle = vehicleService.updateVehicle(dto, vin);

        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<VehicleDTO>> searchVehicles(@ModelAttribute VehicleSearchParams params){
        var vehicleDTOS = vehicleService.searchVehicles(params);
        return new ResponseEntity<>(vehicleDTOS, HttpStatus.OK);
    }
}
