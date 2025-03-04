package carsharing.server.model;

import carsharing.common.model.CarDTO;
import carsharing.common.model.ServiceRecordDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "services")
public class ServiceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime serviceDate;

    private String description;
    private Double cost;

    public ServiceRecord(Integer id, Car car, LocalDateTime serviceDate, Double cost, String description) {
        this.id = id;
        this.car = car;
        this.cost = cost;
        this.description = description;
        this.serviceDate = serviceDate;
    }

    public ServiceRecord(Car car, LocalDateTime serviceDate, Double cost, String description) {
        this.car = car;
        this.cost = cost;
        this.description = description;
        this.serviceDate = serviceDate;
    }

    public ServiceRecord() {
    }

    public ServiceRecordDTO toServiceRecordDTO(){
        return new ServiceRecordDTO(id,car.toCarDTO(),serviceDate,cost,description);
    }

    public static ServiceRecord toServiceRecord(ServiceRecordDTO serviceRecordDTO){
        return new ServiceRecord(serviceRecordDTO.getId(),Car.toCar(serviceRecordDTO.getCar()),
                serviceRecordDTO.getServiceDate(), serviceRecordDTO.getCost(),serviceRecordDTO.getDescription());
    }

    public static List<ServiceRecordDTO> listToServiceRecordDTO(List<ServiceRecord> list){
        List<ServiceRecordDTO> result = new ArrayList<>();

        for(ServiceRecord serviceRecord: list){
            result.add(serviceRecord.toServiceRecordDTO());
        }

        return result;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
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
