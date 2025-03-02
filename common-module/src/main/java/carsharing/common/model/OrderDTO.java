package carsharing.common.model;

public class OrderDTO {

    private Integer id;
    private CarDTO car;
    private UserDTO user;

    private Integer rentalTime;
    private Double totalPrice;

    public OrderDTO(Integer id, CarDTO car, UserDTO user, Integer rentalTime, Double totalPrice) {
        this.car = car;
        this.id = id;
        this.rentalTime = rentalTime;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public OrderDTO() {
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Integer rentalTime) {
        this.rentalTime = rentalTime;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
