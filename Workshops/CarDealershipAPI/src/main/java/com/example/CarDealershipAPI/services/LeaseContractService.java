package com.example.CarDealershipAPI.services;


import com.example.CarDealershipAPI.models.LeaseContract;
import com.example.CarDealershipAPI.models.dto.CreateLeaseContractDTO;
import com.example.CarDealershipAPI.models.dto.LeaseContractDTO;
import com.example.CarDealershipAPI.models.mapper.LeaseContractMapper;
import com.example.CarDealershipAPI.repositories.LeaseContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseContractService {

    @Autowired
    private LeaseContractRepository leaseContractRepository;

    public LeaseContractDTO getLeaseContractById(Integer id){
        LeaseContract leaseContract = leaseContractRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return LeaseContractMapper.toDTO(leaseContract);
    }

    public LeaseContractDTO createLeaseContract(CreateLeaseContractDTO dto){
        LeaseContract leaseContract = LeaseContractMapper.toEntity(dto);
        LeaseContract createdLeaseContract = leaseContractRepository.save(leaseContract);
        return LeaseContractMapper.toDTO(createdLeaseContract);
    }
}
