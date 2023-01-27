package sg.edu.nus.iss.app.ssfassessment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.ssfassessment.model.Order;

@Repository
public class PizzaRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void saveOrder(Order order) {
        redisTemplate.opsForHash().put("Orders_Map", order.getId(), order.getJsonString());
    }

    public String getJsonById(String orderId) {
        String jsonStr = (String) redisTemplate.opsForHash().get("Orders_Map", orderId);
        return jsonStr;
    }
}
