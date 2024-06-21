package com.example.CarDealershipAPI.models;

import com.example.CarDealershipAPI.models.dto.VehicleDTO;
import com.example.CarDealershipAPI.models.mapper.VehicleMapper;
import com.example.CarDealershipAPI.repositories.VehicleRepository;
import com.example.CarDealershipAPI.services.VehicleService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Contract {
    //properties
    @Transient
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
    @Column(name = "DateFinalized")

    private String date;

    private String customerName;
    private String customerEmail;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "vehicle_vin", name = "vehicle_vin")
    private Vehicle vehicle;
    @Setter
    private BigDecimal totalPrice;
    @Setter
    private BigDecimal monthlyPayment;


    //constructor
    public Contract(String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
        this.totalPrice = BigDecimal.ZERO;
        this.monthlyPayment = BigDecimal.ZERO;
    }

    //getters and setters
    public String getDate() {
        date = LocalDate.now().format(fmt);
        return date;
    }


    //methods
    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();
}
