package com.example.CarDealershipAPI.services;


import com.example.CarDealershipAPI.models.LeaseContract;
import com.example.CarDealershipAPI.models.SalesContract;
import com.example.CarDealershipAPI.models.Vehicle;
import com.example.CarDealershipAPI.models.dto.CreateLeaseContractDTO;
import com.example.CarDealershipAPI.models.dto.CreateSalesContractDTO;
import com.example.CarDealershipAPI.models.dto.LeaseContractDTO;
import com.example.CarDealershipAPI.models.dto.SalesContractDTO;
import com.example.CarDealershipAPI.models.mapper.LeaseContractMapper;
import com.example.CarDealershipAPI.models.mapper.SalesContractMapper;
import com.example.CarDealershipAPI.repositories.SalesContractRepository;

import com.example.CarDealershipAPI.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesContractService {
    @Autowired
    private SalesContractRepository salesContractRepository;


    public SalesContractDTO getSalesContractById(Integer id){
        SalesContract salesContract = salesContractRepository.findByIdWithVehicle(id);
        return SalesContractMapper.toDTO(salesContract);
    }

    public SalesContractDTO createSalesContract(CreateSalesContractDTO dto){
        SalesContract salesContract = SalesContractMapper.toEntity(dto);
        SalesContract createdSalesContract = salesContractRepository.save(salesContract);
        return SalesContractMapper.toDTO(createdSalesContract);
    }
}
