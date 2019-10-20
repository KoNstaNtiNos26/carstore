package services;

import model.EntityCar;

import java.util.List;

public interface SimpleRepository {
    EntityCar getCar(int id);
    int postCar(EntityCar car);
    void deleteCar(int id);
    void updateCar(EntityCar newCar);
    List<EntityCar> getAllRecord();
}
