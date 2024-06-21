package com.example.CarDealershipAPI.models.mapper;

import com.example.CarDealershipAPI.models.LeaseContract;
import com.example.CarDealershipAPI.models.SalesContract;
import com.example.CarDealershipAPI.models.Vehicle;
import com.example.CarDealershipAPI.models.dto.CreateLeaseContractDTO;
import com.example.CarDealershipAPI.models.dto.CreateSalesContractDTO;
import com.example.CarDealershipAPI.models.dto.LeaseContractDTO;
import com.example.CarDealershipAPI.models.dto.SalesContractDTO;

import java.math.BigDecimal;

public class SalesContractMapper {
    public static SalesContractDTO toDTO(SalesContract salesContract) {
        SalesContractDTO dto = new SalesContractDTO();
        dto.setDate(salesContract.getDate());
        dto.setCustomerName(salesContract.getCustomerName());
        dto.setCustomerEmail(salesContract.getCustomerEmail());
        dto.setVehicle(salesContract.getVehicle());
        dto.setTotalPrice(salesContract.getTotalPrice());
        dto.setMonthlyPayment(salesContract.getMonthlyPayment());
        dto.setSalesTax(salesContract.getSalesTax());
        dto.setProcessingFee(salesContract.getProcessingFee());
        dto.setFinance(salesContract.isFinance());
        dto.setInterestRate(salesContract.getInterestRate());

        return dto;
    }

    public static SalesContract toEntity(CreateSalesContractDTO dto) {
        SalesContract salesContract = new SalesContract(dto.getCustomerName(), dto.getCustomerEmail(), dto.getVehicleSold(), dto.isFinance());
        salesContract.setDate(dto.getDate());
        salesContract.setCustomerName(dto.getCustomerName());
        salesContract.setCustomerEmail(dto.getCustomerEmail());
        salesContract.setVehicle(dto.getVehicleSold());
        salesContract.setTotalPrice(dto.getTotalPrice());
        salesContract.setMonthlyPayment(dto.getMonthlyPayment());
        salesContract.setSalesTax(dto.getSalesTax());
        salesContract.setProcessingFee(dto.getProcessingFee());
        salesContract.setInterestRate(dto.getInterestRate());

        return salesContract;
    }
}

