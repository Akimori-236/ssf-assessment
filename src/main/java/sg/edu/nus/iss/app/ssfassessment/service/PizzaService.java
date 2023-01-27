package sg.edu.nus.iss.app.ssfassessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.app.ssfassessment.model.Order;
import sg.edu.nus.iss.app.ssfassessment.model.Pizza;
import sg.edu.nus.iss.app.ssfassessment.repository.PizzaRepository;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepo;

    public void saveOrder(Order order, HttpSession session) {
        Pizza pizza = (Pizza) session.getAttribute("pizza");
        order.setPizza(pizza);
        session.setAttribute("order", order);
        System.out.println("%s from %s ordered %s pizza".formatted(order.getName(), order.getAddress(),
                order.getPizza().getPizza()));
        pizzaRepo.saveOrder(order);
    }

    public String getJsonById(String orderId) {
        String jsonStr = pizzaRepo.getJsonById(orderId);
        return jsonStr;
    }

}
