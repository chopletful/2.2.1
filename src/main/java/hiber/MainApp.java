package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CarService carService = context.getBean(CarService.class);
        Car car = new Car("name","1");
        Car car1 = new Car("name1","11");
        Car car2 = new Car("name2","12");
        Car car3 = new Car("name3","13");
        carService.add(car);
        carService.add(car1);
        carService.add(car2);

        UserService userService = context.getBean(UserService.class);
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(car1);
        userService.add(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setCar(car2);
        userService.add(user2);

        System.out.println(userService.findUser("name1","11"));

        context.close();
    }
}
