package carsharing.server.model;


import carsharing.common.model.UserDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="carsharing_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 30)
    private String login;

    @Column(nullable = false, length = 70)
    private String hashPassword;

    @Column(nullable = false, length = 70)
    private String salt;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(name = "total_rental_time", nullable = false)
    private Integer totalRentalTime;

    @Column(name = "total_spent", nullable = false)
    private Double totalSpent;

    public User(Integer id, String firstName, String lastName, Integer totalRentalTime, Double totalSpent, String login, String hashPassword, String salt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalRentalTime = totalRentalTime;
        this.totalSpent = totalSpent;
        this.login = login;
        this.hashPassword = hashPassword;
        this.salt = salt;
    }

    public User() {
        this.totalRentalTime = 0;
        this.totalSpent = 0.;
    }

    public UserDTO toUserDTO(){
        return new UserDTO(id,firstName,lastName,totalRentalTime,totalSpent,login,hashPassword,salt);
    }

    public static User toUser(UserDTO user){
        return new User(user.getId(), user.getFirstName(),user.getLastName(), user.getTotalRentalTime(),
                user.getTotalSpent(), user.getLogin(),user.getHashPassword(),user.getSalt());
    }

    public static List<UserDTO> listToUserDTO(List<User> users){
        List<UserDTO> result = new ArrayList<>();

        for(User u: users){
            result.add(u.toUserDTO());
        }

        return result;
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
