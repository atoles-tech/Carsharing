package carsharing.server.model;


import carsharing.common.model.AdminDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carsharing_admin")
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 30)
    private String login;

    @Column(length = 70)
    private String hashPassword;

    @Column(length = 70)
    private String salt;

    public Admin(Integer id, String login, String hashPassword, String salt) {
        this.id = id;
        this.login = login;
        this.hashPassword = hashPassword;
        this.salt = salt;
    }

    public Admin(String login, String hashPassword, String salt) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.salt = salt;
    }

    public Admin() {
    }

    public AdminDTO toAdminDTO(){
        return new AdminDTO(id,login,hashPassword,salt);
    }

    public static Admin toAdmin(AdminDTO admin){
        return new Admin(admin.getId(), admin.getLogin(), admin.getHashPassword(), admin.getSalt());
    }

    public static List<AdminDTO> listToAdminDTO(List<Admin> list){
        List<AdminDTO> result = new ArrayList<>();

        for(Admin a: list){
            result.add(a.toAdminDTO());
        }

        return result;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
