package sg.edu.nus.iss.app.ssfassessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.ssfassessment.model.Order;
import sg.edu.nus.iss.app.ssfassessment.model.Pizza;
import sg.edu.nus.iss.app.ssfassessment.repository.PizzaRepository;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepo;

    public Double totalCost(Pizza pizza, Order order) {
        Double totalCost = pizza.cost();

        if (order.isRush()) {
            return totalCost += 2;
        }
        return totalCost;
    }
}
