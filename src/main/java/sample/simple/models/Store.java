package sample.simple.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import sample.simple.interfaces.IFastLane;
import sample.simple.interfaces.IJustHaveALook;
import sample.simple.interfaces.ILane;
import sample.simple.interfaces.IStore;

import java.util.Map;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@Component
public class Store implements IFastLane, IJustHaveALook, ILane, IStore {
    private Long id;
    private Address address;
    private String name;
    private Long bankAccountAddress;
    private Map<Long, Integer> stock;

    @Override
    public Boolean oneShotOrder(Long articleId, Long clientId, Integer quantity) {
        System.out.println("Client " + clientId + " oneShot ordered " + quantity + " article(s) " + articleId);
        return Boolean.TRUE;
    }

    @Override
    public Double getPrice(Long id) {
        Random random = new Random();
        return random.nextDouble();
    }

    @Override
    public Boolean isAvailable(Long id) {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public Boolean addItemToCart(Long articleId, Long clientId) {
        System.out.println("Item: " + articleId + " added to client " + clientId + " cart");
        return Boolean.TRUE;
    }

    @Override
    public Boolean pay(Long clientId) {
        System.out.println("Client " + clientId + " paid for his cart");
        return Boolean.TRUE;
    }
}
