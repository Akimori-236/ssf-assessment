package sg.edu.nus.iss.app.ssfassessment.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Pizza {
    @NotNull(message = "Please select pizza type")
    @Pattern(regexp = "^(bella|margherita|marinara|spianatacalabrese|trioformaggio)$", message = "Pizza selection not available")
    private String pizza;

    @NotNull(message = "Please select pizza size")
    @Pattern(regexp = "^(sm|md|lg)$", message = "Pizza size not available")
    private String size;

    @Min(value = 1, message = "Minimum order is 1")
    @Max(value = 10, message = "Maximum order is 10")
    private int quantity;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}