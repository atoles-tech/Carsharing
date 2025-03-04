package carsharing.server.db;

import carsharing.common.model.UserDTO;
import carsharing.server.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class EmployeManager {

    private static EmployeManager employeManager;
    private SessionFactory sessionFactory;

    private EmployeManager(){
        this.sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static void init(){
        if(employeManager == null){
            employeManager = new EmployeManager();
        }
    }

    public static EmployeManager getInstance(){
        if(employeManager == null){
            employeManager = new EmployeManager();
        }
        return employeManager;
    }

    public List<UserDTO> getUsers(){
        try(Session session = sessionFactory.openSession()){
            return User.listToUserDTO(session.createNativeQuery("select * from carsharing_user", User.class).getResultList());
        }
    }
}
