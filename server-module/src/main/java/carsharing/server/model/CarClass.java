package carsharing.server.model;

import carsharing.common.model.CarClassDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car_class")
public class CarClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",length = 50)
    private String name;

    public CarClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CarClass(String name) {
        this.name = name;
    }

    public CarClass() {
    }

    public CarClassDTO toCarClassDTO(){
        return new CarClassDTO(id,name);
    }

    public static CarClass toCarClass(CarClassDTO carClass){
        return new CarClass(carClass.getId(), carClass.getName());
    }

    public static List<CarClassDTO> listToCarClassDTO(List<CarClass> list){
        List<CarClassDTO> result = new ArrayList<>();

        for(CarClass carClass: list){
            result.add(carClass.toCarClassDTO());
        }

        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
