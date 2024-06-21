package com.example.CarDealershipAPI.controllers;

import com.example.CarDealershipAPI.models.dto.CreateLeaseContractDTO;
import com.example.CarDealershipAPI.models.dto.LeaseContractDTO;
import com.example.CarDealershipAPI.services.LeaseContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/CarDealership/LeaseContracts")
public class LeaseContractController {
    @Autowired
    private LeaseContractService leaseContractService;

    @GetMapping("/{id}")
    public ResponseEntity<LeaseContractDTO> getLeaseContractById(@PathVariable Integer id){
        return new ResponseEntity<>(leaseContractService.getLeaseContractById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LeaseContractDTO> createLeaseContract(@Valid @RequestBody CreateLeaseContractDTO dto){
        var leaseContract = leaseContractService.createLeaseContract(dto);
        return new ResponseEntity<>(leaseContract, HttpStatus.OK);
    }

}
