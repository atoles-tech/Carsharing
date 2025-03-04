package carsharing.common.model;

import java.io.Serializable;

public class AdminDTO implements Serializable {

    private Integer id;

    private String login;
    private String hashPassword;
    private String salt;

    public AdminDTO(Integer id, String login, String hashPassword, String salt) {
        this.id = id;
        this.login = login;
        this.hashPassword = hashPassword;
        this.salt = salt;
    }

    public AdminDTO() {
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "hashPassword='" + hashPassword + '\'' +
                ", id=" + id +
                ", login='" + login + '\'' +
                ", salt='" + salt + '\'' +
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
}
