package sg.edu.nus.iss.app.ssfassessment.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssfassessment.model.Pizza;

@Controller
@RequestMapping(path = "/pizza")
public class PizzaController {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String pizzaForm(@Valid Pizza pizza, BindingResult binding, Model model) {
        if (binding.hasErrors()) {
            System.err.println(binding.getAllErrors().get(0).getDefaultMessage().toString());
            model.addAttribute("pizza", pizza);
            return "index";
        }
        return "deliverydetails";
    }

    @PostMapping(path = "/order")
    public String detailsForm() {
        return "";
    }
}
