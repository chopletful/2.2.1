package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findUser(String model, String series) {
      TypedQuery<Car> findCarQuery = sessionFactory.getCurrentSession().createQuery("from Car where name = :car_name and series = :car_series")
              .setParameter("car_name", model)
              .setParameter("car_series", series);
      List<Car> findCarList = findCarQuery.getResultList();
      return findCarList.get(0).getUser();

//      String HQL = "FROM Car car LEFT OUTER JOIN FETCH car.user WHERE car.name=:model AND car.series=:series ";
//      Car car = sessionFactory.getCurrentSession()
//              .createQuery(HQL, Car.class).setParameter("model", model).uniqueResult();
//      return List<User>

   }
}


