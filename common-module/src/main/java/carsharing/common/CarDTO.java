package carsharing.common;

public class CarDTO {

    private Integer id;
    private String brand;
    private String model;

    private Integer totalRentalTime;
    private Double totalEarned;

    public CarDTO(Integer id, String brand, String model, Double totalEarned, Integer totalRentalTime) {
        this.brand = brand;
        this.id = id;
        this.model = model;
        this.totalEarned = totalEarned;
        this.totalRentalTime = totalRentalTime;
    }

    public CarDTO() {}

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
