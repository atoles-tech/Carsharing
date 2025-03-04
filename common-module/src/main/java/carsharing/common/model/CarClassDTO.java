package carsharing.common.model;

import java.io.Serializable;

public class CarClassDTO implements Serializable {
    private Integer id;
    private String name;

    public CarClassDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CarClassDTO() {
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
