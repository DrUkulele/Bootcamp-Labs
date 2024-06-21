package com.example.CarDealershipAPI.QueryBuilder;

import com.example.CarDealershipAPI.models.Vehicle;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecifications {

    public static Specification<Vehicle> yearBetween(Integer minYear, Integer maxYear){
        return (root, query, criteriaBuilder) -> {
            if (minYear == null && maxYear == null) {
                return criteriaBuilder.conjunction();
            }
            if(minYear == null){
                return criteriaBuilder.lessThanOrEqualTo(root.get("year") , maxYear);
            }
            if(maxYear == null){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("year"), minYear);
            }
            return criteriaBuilder.between(root.get("year"), minYear, maxYear);
        };
    }

    public static Specification<Vehicle> vehicleMakeContains(String vehicleMake){
        return (root, query, criteriaBuilder) -> {
            if (vehicleMake == null || vehicleMake.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("make"), "%" + vehicleMake + "%");
        };
    }

    public static Specification<Vehicle> vehicleModelContains(String vehicleModel){
        return (root, query, criteriaBuilder) -> {
            if (vehicleModel == null || vehicleModel.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("model"), "%" + vehicleModel + "%");
        };
    }

    public static Specification<Vehicle> vehicleTypeContains(String vehicleType){
        return (root, query, criteriaBuilder) -> {
            if (vehicleType == null || vehicleType.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("type"), "%" + vehicleType + "%");
        };
    }

    public static Specification<Vehicle> vehicleColorContains(String color){
        return (root, query, criteriaBuilder) -> {
            if (color == null || color.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("color"), "%" + color + "%");
        };
    }

    public static Specification<Vehicle> odometerBetween(Integer minOdometer, Integer maxOdometer){
        return (root, query, criteriaBuilder) -> {
            if (minOdometer == null && maxOdometer == null) {
                return criteriaBuilder.conjunction();
            }
            if(minOdometer == null){
                return criteriaBuilder.lessThanOrEqualTo(root.get("Odometer") , maxOdometer);
            }
            if(maxOdometer == null){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("Odometer"), minOdometer);
            }
            return criteriaBuilder.between(root.get("Odometer"), minOdometer, maxOdometer);
        };
    }

    public static Specification<Vehicle> priceBetween(Double minPrice, Double maxPrice){
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null) {
                return criteriaBuilder.conjunction();
            }
            if(minPrice == null){
                return criteriaBuilder.lessThanOrEqualTo(root.get("Price") , maxPrice);
            }
            if(maxPrice == null){
                return criteriaBuilder.greaterThanOrEqualTo(root.get("Price"), minPrice);
            }
            return criteriaBuilder.between(root.get("Price"), minPrice, maxPrice);
        };
    }

    public static Specification<Vehicle> vehicleIsSold(Boolean sold) {
        return (root, query, criteriaBuilder) -> {
            if(sold == null){
                return criteriaBuilder.conjunction();
            }
            if (sold) {
                return criteriaBuilder.isTrue(root.get("sold"));
            } else {
                return criteriaBuilder.isFalse(root.get("sold"));
            }
        };
    }
}
