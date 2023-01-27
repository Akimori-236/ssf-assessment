package sg.edu.nus.iss.app.ssfassessment.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssfassessment.model.Order;
import sg.edu.nus.iss.app.ssfassessment.model.Pizza;

@Controller
@RequestMapping(path = "/pizza")
public class PizzaController {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String pizzaForm(@Valid Pizza pizza, BindingResult binding, Model model, HttpSession session) {
        if (binding.hasErrors()) {
            System.err.println(binding.getAllErrors().get(0).getDefaultMessage().toString());
            model.addAttribute("pizza", pizza);
            return "index";
        }
        session.setAttribute("pizza", pizza);
        System.out.println("NEW ORDER: %s x %s (%s)".formatted(pizza.getQuantity(), pizza.getPizza(), pizza.getSize()));
        model.addAttribute("order", new Order());
        return "deliverydetails";
    }

    @PostMapping(path = "/order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String detailsForm(@Valid Order order, BindingResult binding, Model model, HttpSession session) {
        if (binding.hasErrors()) {
            System.err.println(binding.getAllErrors().get(0).getDefaultMessage().toString());
            model.addAttribute("order", order);
            return "deliverydetails";
        }
        Pizza pizza = (Pizza)session.getAttribute("pizza");
        System.out.println("%s from %s ordered %s pizza".formatted(order.getName(), order.getAddress(), pizza.getPizza()));
        model.addAttribute("order", order);
        model.addAttribute("pizza", pizza);
        return "success";
    }
}
