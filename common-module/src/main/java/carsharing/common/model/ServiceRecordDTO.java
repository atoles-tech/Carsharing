package carsharing.common.model;

import java.time.LocalDateTime;

public class ServiceRecordDTO {

    private Integer id;

    private CarDTO car;

    private LocalDateTime serviceDate;

    private String description;
    private Double cost;

    public ServiceRecordDTO(Integer id, CarDTO car, LocalDateTime serviceDate, Double cost, String description) {
        this.car = car;
        this.cost = cost;
        this.description = description;
        this.id = id;
        this.serviceDate = serviceDate;
    }

    public ServiceRecordDTO() {
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDateTime serviceDate) {
        this.serviceDate = serviceDate;
    }
}
