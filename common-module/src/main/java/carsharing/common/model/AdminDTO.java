package carsharing.common.model;

public class AdminDTO {

    private Integer id;

    private String login;
    private String hashPassword;
    private byte[] salt;

    public AdminDTO(Integer id, String login, String hashPassword, byte[] salt) {
        this.id = id;
        this.login = login;
        this.hashPassword = hashPassword;
        this.salt = salt;
    }

    public AdminDTO() {
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
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
