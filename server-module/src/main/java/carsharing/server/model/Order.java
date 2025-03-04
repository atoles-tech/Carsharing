package carsharing.server.model;

import carsharing.common.model.CarDTO;
import carsharing.common.model.OrderDTO;
import carsharing.common.model.UserDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime orderTime;

    private Integer rentalTime;
    private Double totalPrice;

    public Order(Integer id,Car car, User user, LocalDateTime orderTime, Integer rentalTime, Double totalPrice) {
        this.id = id;
        this.car = car;
        this.rentalTime = rentalTime;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public Order(Car car, User user, LocalDateTime orderTime, Integer rentalTime, Double totalPrice) {
        this.car = car;
        this.rentalTime = rentalTime;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public Order() {}

    public OrderDTO toOrderDTO(){
        return new OrderDTO(id,car.toCarDTO(),user.toUserDTO(), orderTime,rentalTime,totalPrice);
    }

    public static Order toOrder(OrderDTO orderDTO){
        return new Order(orderDTO.getId(),Car.toCar(orderDTO.getCar()), User.toUser(orderDTO.getUser()),
                orderDTO.getOrderTime(),orderDTO.getRentalTime(), orderDTO.getTotalPrice());
    }

    public static List<OrderDTO> toListOrderDTO(List<Order> list){
        List<OrderDTO> result = new ArrayList<>();

        for(Order order: list){
            result.add(order.toOrderDTO());
        }

        return result;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
