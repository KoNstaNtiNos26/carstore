package services;

import model.EntityCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class SimpleRepositoryImpl implements SimpleRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public EntityCar getCar(int id) {
        EntityTransaction tr = entityManager.getTransaction();
        EntityCar car = null;
        tr.begin();
        try {
            car = entityManager.find(EntityCar.class, id);
            if(Objects.isNull(car)) throw new Exception("row dont find");
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            return car;
        }
        return car;
    }

    @Override
    public void deleteCar(int id) {
        EntityTransaction tr = entityManager.getTransaction();
        tr.begin();
        try {
            EntityCar car = entityManager.find(EntityCar.class, id);
            if(Objects.isNull(car)) throw new Exception("row dont find");
            entityManager.remove(car);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
    }

    @Override
    public int postCar(EntityCar car) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(car);
            transaction.commit();
        } catch (PersistenceException e) {
            transaction.rollback();
            return -1;
        }
        return car.getId();
    }

    @Override
    public void updateCar(EntityCar newCar) {
        EntityTransaction tr = entityManager.getTransaction();
        tr.begin();
        try {
            EntityCar car = entityManager.find(EntityCar.class, newCar.getId());
            if(Objects.isNull(car)) throw new Exception("row dont find");
            if(!"".equals(newCar.getBodywork()) && !newCar.getBodywork().equals(car.getBodywork())) {
                car.setBodywork(newCar.getBodywork());
            }
            if(!"".equals(newCar.getCarmod()) && !newCar.getCarmod().equals(car.getCarmod())) {
                car.setCarmod(newCar.getCarmod());
            }
            if(!"".equals(newCar.getProducer()) && !newCar.getProducer().equals(car.getProducer())) {
                car.setProducer(newCar.getProducer());
            }
            if(!"".equals(newCar.getYearproduce()) && !newCar.getYearproduce().equals(car.getYearproduce())) {
                car.setYearproduce(newCar.getYearproduce());
            }
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
    }

    @Override
    public List<EntityCar> getAllRecord() {
        EntityTransaction transaction = entityManager.getTransaction();
        List<EntityCar> resultList = null;
        transaction.begin();
        try {
            TypedQuery<EntityCar> query = entityManager.createQuery("select c from EntityCar c", EntityCar.class);
            resultList = query.getResultList();

            transaction.commit();
        } catch (PersistenceException e) {
            transaction.rollback();
        }
        return resultList;
    }
}
