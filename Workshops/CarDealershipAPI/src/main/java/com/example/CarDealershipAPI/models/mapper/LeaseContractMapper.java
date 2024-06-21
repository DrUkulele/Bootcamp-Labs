package com.example.CarDealershipAPI.models.mapper;

import com.example.CarDealershipAPI.models.LeaseContract;
import com.example.CarDealershipAPI.models.Vehicle;
import com.example.CarDealershipAPI.models.dto.CreateLeaseContractDTO;
import com.example.CarDealershipAPI.models.dto.LeaseContractDTO;

import java.math.BigDecimal;

public class LeaseContractMapper {
    public static LeaseContractDTO toDTO(LeaseContract leaseContract){
        LeaseContractDTO dto = new LeaseContractDTO();
        dto.setDate(leaseContract.getDate());
        dto.setCustomerName(leaseContract.getCustomerName());
        dto.setCustomerEmail(leaseContract.getCustomerEmail());
        dto.setVehicle_vin(leaseContract.getVehicle().getVin());
        dto.setTotalPrice(leaseContract.getTotalPrice());
        dto.setMonthlyPayment(leaseContract.getMonthlyPayment());
        dto.setVehiclePrice(leaseContract.getVehiclePrice());
        dto.setLeaseFee(leaseContract.getLeaseFee());


       return dto;
    }

    public static LeaseContract toEntity(CreateLeaseContractDTO dto){
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setDate(dto.getDate());
        leaseContract.setCustomerName(dto.getCustomerName());
        leaseContract.setCustomerEmail(dto.getCustomerEmail());
        leaseContract.setVehicle(dto.getVehicle());
        leaseContract.setTotalPrice(dto.getTotalPrice());
        leaseContract.setMonthlyPayment(dto.getMonthlyPayment());
        leaseContract.setVehiclePrice(dto.getVehiclePrice());
        leaseContract.setLeaseFee(dto.getLeaseFee());
        return leaseContract;
    }
}
