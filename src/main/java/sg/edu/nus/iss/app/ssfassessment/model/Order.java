package sg.edu.nus.iss.app.ssfassessment.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Order {
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be minimum 3 characters")
    private String name;

    @NotNull(message = "Address cannot be null")
    private String address;

    @Size(min = 8, max=8, message = "Phone number must be 8 digits")
    private String phone;

    private Boolean rush = false;
    
    private String comments;

    private Pizza pizza;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isRush() {
        return rush;
    }

    public void setRush(Boolean rush) {
        this.rush = rush;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

}
