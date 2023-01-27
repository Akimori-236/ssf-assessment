package sg.edu.nus.iss.app.ssfassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.ssfassessment.service.PizzaService;
import sg.edu.nus.iss.app.ssfassessment.util.JsonUtil;

@RestController
@RequestMapping(path = "/order")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaSvc;

    @GetMapping(path = "{orderId}")
    public ResponseEntity<String> getOrder(@PathVariable String orderId) {
        String jsonStr = pizzaSvc.getJsonById(orderId);
        if (jsonStr == "" || jsonStr == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(JsonUtil.notFoundJson(orderId));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonStr);
    }
}
