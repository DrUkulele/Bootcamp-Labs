package com.example.CarDealershipAPI.services;

import com.example.CarDealershipAPI.QueryBuilder.VehicleSpecifications;
import com.example.CarDealershipAPI.models.Vehicle;
import com.example.CarDealershipAPI.models.dto.CreateVehicleDTO;
import com.example.CarDealershipAPI.models.dto.UpdateVehicleDTO;
import com.example.CarDealershipAPI.models.dto.VehicleDTO;
import com.example.CarDealershipAPI.models.mapper.VehicleMapper;
import com.example.CarDealershipAPI.models.params.VehicleSearchParams;
import com.example.CarDealershipAPI.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(VehicleMapper::toDTO).toList();
    }

    public VehicleDTO getVehicleByVin(Integer vin){
        Vehicle vehicle = vehicleRepository.findById(vin).orElseThrow(() -> new RuntimeException());
        return VehicleMapper.toDTO(vehicle);
    }

    public void deleteVehicle(Integer vin){
        Vehicle vehicle = vehicleRepository.findById(vin).orElseThrow(() -> new RuntimeException());
        vehicleRepository.delete(vehicle);
    }

    public VehicleDTO createVehicle(CreateVehicleDTO dto){
        Vehicle vehicle = VehicleMapper.toEntity(dto);
        Vehicle createdVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.toDTO(createdVehicle);
    }

    public VehicleDTO updateVehicle(UpdateVehicleDTO dto, Integer vin){
        Vehicle vehicle = VehicleMapper.toEntity(dto);
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.toDTO(updatedVehicle);

    }

    public List<VehicleDTO> searchVehicles(VehicleSearchParams params){
        Specification<Vehicle> spec = Specification.where(VehicleSpecifications.yearBetween(params.getMinYear(), params.getMaxYear()));
        List<Vehicle> vehicles = vehicleRepository.findAll(spec);
        return vehicles.stream().map(VehicleMapper::toDTO).collect(Collectors.toList());
    }
}

