package Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class CartEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private Double price;

    @ManyToOne
    private UserEntity userByUserId;

    @OneToMany(mappedBy = "cartByCartId")
    private Collection<CartItemEntity> cartItemsById;

    @OneToMany(mappedBy = "cartByCartId")
    private Collection<OrdersEntity> ordersById;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntity that = (CartEntity) o;

        if (id != that.id) return false;
        return price != null ? price.equals(that.price) : that.price == null;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return (int) result;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Collection<CartItemEntity> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItemEntity> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }

    public Collection<OrdersEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrdersEntity> ordersById) {
        this.ordersById = ordersById;
    }
}
