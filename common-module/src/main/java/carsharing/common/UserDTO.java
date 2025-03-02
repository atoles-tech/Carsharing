package carsharing.common;

public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;

    private Integer totalRentalTime;
    private Double totalSpent;

    public UserDTO(Integer id ,String firstName, String lastName,Integer totalRentalTime, Double totalSpent) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.totalRentalTime = totalRentalTime;
        this.totalSpent = totalSpent;
    }

    public UserDTO() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTotalRentalTime() {
        return totalRentalTime;
    }

    public void setTotalRentalTime(Integer totalRentalTime) {
        this.totalRentalTime = totalRentalTime;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }
}
