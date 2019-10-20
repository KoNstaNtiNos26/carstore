package controllers;

import model.EntityCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.SimpleRepository;
import services.SimpleRepositoryImpl;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/store")
public class SimpleController {

    @Autowired
    private SimpleRepository repository;

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createCarRecord(String year, String producer, String bodyWork, String carModel, Model model) {
        EntityCar car = new EntityCar();
        car.setBodywork(bodyWork);
        car.setCarmod(carModel);
        car.setProducer(producer);
        car.setYearproduce(year);
        int id = repository.postCar(car);
        System.out.println("id: " + id);
        model.addAttribute("id", id);
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCarRecord(EntityCar car, Model model) {
        if(car.getId() == -1) {
            model.addAttribute("reason", "Неверный ключ. Повторите попытку");
            return "index";
        }
        if(Objects.isNull(repository.getCar(car.getId()))) {
            model.addAttribute("reason", "Неверный ключ. Повторите попытку");
            return "index";
        }
        System.out.println(car.getId());
        System.out.println(car.getBodywork());
        System.out.println(car.getCarmod());
        System.out.println(car.getProducer());
        System.out.println(car.getYearproduce());
        repository.updateCar(car);
        return "redirect: /store/all";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String deleteCarRecord(@RequestParam("id") int id, Model model) {
        repository.deleteCar(id);
        return "redirect:/store/all";
    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String getCarRecord(int id, Model model) {
//        Car car = repository.getCar(id);
//        if(Objects.nonNull(car)) model.addAttribute("car", car);
//        else model.addAttribute("answer", "запись не обнаружена");
//        return "index";
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllRecord(Model model) {
        List<EntityCar> allRecord = repository.getAllRecord();
        model.addAttribute("listCars", allRecord);
        return "allRows";
    }
}
