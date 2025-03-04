package carsharing.server.model;

import carsharing.common.model.CarClassDTO;
import carsharing.common.model.CarDTO;
import carsharing.common.model.CarTypeDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String brand;

    @Column(length = 30)
    private String model;

    private Double pricePerMinute;

    private Integer totalRentalTime;
    private Double totalEarned;

    @Enumerated(EnumType.STRING)
    private CarTypeDTO carType;

    @ManyToOne
    @JoinColumn(name = "car_class_id")
    private CarClass carClass;

    public Car(Integer id, String brand, String model, Double pricePerMinute, Double totalEarned,
                  Integer totalRentalTime, CarTypeDTO carType, CarClass carClass) {
        this.brand = brand;
        this.id = id;
        this.model = model;
        this.pricePerMinute = pricePerMinute;
        this.totalEarned = totalEarned;
        this.totalRentalTime = totalRentalTime;
        this.carType = carType;
        this.carClass = carClass;
    }

    public Car(String brand, String model, Double pricePerMinute, Double totalEarned,
               Integer totalRentalTime, CarTypeDTO carType, CarClass carClass) {
        this.brand = brand;
        this.model = model;
        this.pricePerMinute = pricePerMinute;
        this.totalEarned = totalEarned;
        this.totalRentalTime = totalRentalTime;
        this.carType = carType;
        this.carClass = carClass;
    }

    public Car() {}

    public CarDTO toCarDTO(){
        return new CarDTO(id,brand,model,pricePerMinute,totalEarned,totalRentalTime,carType,carClass.toCarClassDTO());
    }

    public static Car toCar(CarDTO car){
        return new Car(car.getId(), car.getBrand(), car.getModel(), car.getPricePerMinute(),
                car.getTotalEarned(), car.getTotalRentalTime(), car.getCarType(),CarClass.toCarClass(car.getCarClass()));
    }

    public static List<CarDTO> listToCarDTO(List<Car> cars){
        List<CarDTO> result = new ArrayList<>();

        for(Car car: cars){
            result.add(car.toCarDTO());
        }

        return result;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public CarTypeDTO getCarType() {
        return carType;
    }

    public void setCarType(CarTypeDTO carType) {
        this.carType = carType;
    }

    public Double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(Double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(Double totalEarned) {
        this.totalEarned = totalEarned;
    }

    public Integer getTotalRentalTime() {
        return totalRentalTime;
    }

    public void setTotalRentalTime(Integer totalRentalTime) {
        this.totalRentalTime = totalRentalTime;
    }
}
