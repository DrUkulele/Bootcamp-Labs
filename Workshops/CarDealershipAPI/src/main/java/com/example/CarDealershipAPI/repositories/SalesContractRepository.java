package com.example.CarDealershipAPI.repositories;


import com.example.CarDealershipAPI.models.SalesContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesContractRepository extends JpaRepository<SalesContract, Integer> {

    @Query("SELECT sc FROM SalesContract sc JOIN FETCH sc.vehicle WHERE sc.salesContractId = :id")
    SalesContract findByIdWithVehicle(@Param("id") int id);
}
