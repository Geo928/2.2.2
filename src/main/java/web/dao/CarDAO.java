package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    public List<Car> show(List<Car> list, int quantity) {
        List<Car> result = new ArrayList<>(list);
        if (quantity == 0 || quantity > 5) {
            return result;
        }
        return result.stream()
                   .limit(quantity)
                   .toList();
    }
}
