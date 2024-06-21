package com.example.CarDealershipAPI.repositories;

import com.example.CarDealershipAPI.models.LeaseContract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseContractRepository extends JpaRepository<LeaseContract, Integer> {
}
