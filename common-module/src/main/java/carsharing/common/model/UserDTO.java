package carsharing.common.model;

import java.io.Serializable;
import java.util.Arrays;

public class UserDTO implements Serializable {

    private Integer id;

    private String login;
    private String hashPassword;
    private String salt;

    private String firstName;
    private String lastName;

    private Integer totalRentalTime;
    private Double totalSpent;

    public UserDTO(Integer id, String firstName, String lastName, Integer totalRentalTime, Double totalSpent, String login, String hashPassword, String salt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalRentalTime = totalRentalTime;
        this.totalSpent = totalSpent;
        this.login = login;
        this.hashPassword = hashPassword;
        this.salt = salt;
    }

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", id=" + id +
                ", login='" + login + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", lastName='" + lastName + '\'' +
                ", totalRentalTime=" + totalRentalTime +
                ", totalSpent=" + totalSpent +
                '}';
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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
