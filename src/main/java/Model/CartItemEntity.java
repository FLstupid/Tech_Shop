package Model;

import javax.persistence.*;

@Entity
public class CartItemEntity {
    @Id
    private int id;
    private Integer cartId;
    private long productId;
    private short amount;

    @ManyToOne
    private CartEntity cartByCartId;

    @ManyToOne
    private ProductEntity productByProductId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public short getAmount() {
        return amount;
    }

    public void setAmount(short amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItemEntity that = (CartItemEntity) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (amount != that.amount) return false;
        if (cartId != null ? !cartId.equals(that.cartId) : that.cartId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        result = 31 * result + (int) (productId ^ (productId >>> 32));
        result = 31 * result + (int) amount;
        return result;
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
