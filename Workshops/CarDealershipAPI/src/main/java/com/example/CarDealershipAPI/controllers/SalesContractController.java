package com.example.CarDealershipAPI.controllers;

import com.example.CarDealershipAPI.models.dto.CreateSalesContractDTO;
import com.example.CarDealershipAPI.models.dto.SalesContractDTO;
import com.example.CarDealershipAPI.services.SalesContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/CarDealership/SalesContracts")
public class SalesContractController {
    @Autowired
    private SalesContractService salesContractService;

    @GetMapping("/{id}")
    public ResponseEntity<SalesContractDTO> getSalesContractById(@PathVariable Integer id){
        return new ResponseEntity<>(salesContractService.getSalesContractById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SalesContractDTO> createSalesContract(@Valid @RequestBody CreateSalesContractDTO dto){
        var salesContract = salesContractService.createSalesContract(dto);
        return new ResponseEntity<>(salesContract, HttpStatus.OK);
    }
}
