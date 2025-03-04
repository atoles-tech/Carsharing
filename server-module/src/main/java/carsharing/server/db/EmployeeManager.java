package carsharing.server.db;

import carsharing.common.model.*;
import carsharing.server.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class EmployeeManager {

    private static EmployeeManager employeeManager;
    private SessionFactory sessionFactory;

    private EmployeeManager(){
        this.sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static void init(){
        if(employeeManager == null){
            employeeManager = new EmployeeManager();
        }
    }

    public static EmployeeManager getInstance(){
        if(employeeManager == null){
            employeeManager = new EmployeeManager();
        }
        return employeeManager;
    }

    public List<UserDTO> getUsers(){
        try(Session session = sessionFactory.openSession()){
            return User.listToUserDTO(session.createNativeQuery("select * from carsharing_user", User.class).getResultList());
        }
    }

    public void saveUser(User user){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();
        }
    }

    public void updateUser(User user){ // this method can be use only for update
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.merge(user);

            transaction.commit();
        }
    }

    public User getUserById(Integer id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, id);

            transaction.commit();

            return user;
        }
    }

    public List<AdminDTO> getAdmins(){
        try(Session session = sessionFactory.openSession()){
            return Admin.listToAdminDTO(session.createNativeQuery("select * from carsharing_admin", Admin.class).getResultList());
        }
    }

    public void saveAdmin(Admin admin){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.persist(admin);

            transaction.commit();
        }
    }

    public void updateAdmin(Admin admin){ // this method can be use only for update
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.merge(admin);

            transaction.commit();
        }
    }

    public List<CarClassDTO> getCarClasses(){
        try(Session session = sessionFactory.openSession()){
            return CarClass.listToCarClassDTO(session.createNativeQuery("select * from car_class", CarClass.class).getResultList());
        }
    }

    public CarClass getCarClassById(Integer id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            CarClass carClass = session.get(CarClass.class, id);

            transaction.commit();

            return carClass;
        }
    }

    public void saveCarClass(CarClass carClass){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.persist(carClass);

            transaction.commit();
        }
    }

    public void updateCarClass(CarClass carClass){ // this method can be use only for update
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.merge(carClass);

            transaction.commit();
        }
    }

    public List<CarDTO> getCars(){
        try(Session session = sessionFactory.openSession()){
            return Car.listToCarDTO(session.createNativeQuery("select * from cars", Car.class).getResultList());
        }
    }

    public void saveCar(Car car){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.persist(car);

            transaction.commit();
        }
    }

    public void updateCar(Car car){ // this method can be use only for update
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.merge(car);

            transaction.commit();
        }
    }

    public Car getCarById(Integer id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            Car car = session.get(Car.class,id);

            transaction.commit();
            return car;
        }
    }

    public List<OrderDTO> getOrders(){
        try(Session session = sessionFactory.openSession()){
            return Order.toListOrderDTO(session.createNativeQuery("select * from orders", Order.class).getResultList());
        }
    }

    public void saveOrder(Order order){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.persist(order);

            transaction.commit();
        }
    }

    public void updateOrder(Order order){ // this method can be use only for update
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.merge(order);

            transaction.commit();
        }
    }

    public List<ServiceRecordDTO> getServices(){
        try(Session session = sessionFactory.openSession()){
            return ServiceRecord.listToServiceRecordDTO(session.createNativeQuery("select * from services", ServiceRecord.class).getResultList());
        }
    }

    public void saveServiceRecord(ServiceRecord serviceRecord){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.persist(serviceRecord);

            transaction.commit();
        }
    }

    public void updateServiceRecord(ServiceRecord serviceRecord){ // this method can be use only for update
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.merge(serviceRecord);

            transaction.commit();
        }
    }
}
