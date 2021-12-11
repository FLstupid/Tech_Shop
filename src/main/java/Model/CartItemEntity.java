package Model;

import javax.persistence.*;

@Entity
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private short amount;

    @ManyToOne
    private CartEntity cartByCartId;

    @ManyToOne
    private ProductEntity productByProductId;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getAmount() {
        return amount;
    }

    public void setAmount(short amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (int) amount;
        return (int) result;
    }

    public CartEntity getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(CartEntity cartByCartId) {
        this.cartByCartId = cartByCartId;
    }

    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
