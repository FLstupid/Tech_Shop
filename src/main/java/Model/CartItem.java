package Model;

import javax.persistence.*;

@Table(name = "cart_item", indexes = {
        @Index(name = "productId", columnList = "productId"),
        @Index(name = "cartId", columnList = "cartId")
})
@Entity
public class CartItem {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cartId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", nullable = false)
    private Product productId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}