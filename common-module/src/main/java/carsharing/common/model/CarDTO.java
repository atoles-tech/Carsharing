package carsharing.common.model;

public class CarDTO {

    private Integer id;
    private String brand;
    private String model;

    private Double pricePerMinute;

    private Integer totalRentalTime;
    private Double totalEarned;

    private CarTypeDTO carType;
    private CarClassDTO carClass;

    public CarDTO(Integer id, String brand, String model, Double pricePerMinute, Double totalEarned,
                  Integer totalRentalTime, CarTypeDTO carType, CarClassDTO carClass) {
        this.brand = brand;
        this.id = id;
        this.model = model;
        this.pricePerMinute = pricePerMinute;
        this.totalEarned = totalEarned;
        this.totalRentalTime = totalRentalTime;
        this.carType = carType;
        this.carClass = carClass;
    }

    public CarDTO() {}

    public CarClassDTO getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClassDTO carClass) {
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
