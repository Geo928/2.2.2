package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final CarDAO carDAO;

    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int quantity, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Tesla", "White"));
        cars.add(new Car(2, "BMW", "Black"));
        cars.add(new Car(3, "Mercedes", "Grey"));
        cars.add(new Car(4, "Ferrari", "Red"));
        cars.add(new Car(5, "Lada", "Blue"));
        cars = carDAO.show(cars, quantity);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
