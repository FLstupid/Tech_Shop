package Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ProductEntity {
    @Id
    private long id;
    private String productName;
    private Long categoryId;
    private String picture;
    private Double price;
    private String nsx;
    private String content;

    @OneToMany(mappedBy = "productByProductId")
    private Collection<CartItemEntity> cartItemsById;

    @ManyToOne
    private CategoryEntity categoryByCategoryId;

    public ProductEntity(String productName, String productimage, Double productprice, String productcontent, String productnsx1, CategoryEntity category) {
    }

    public ProductEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (nsx != null ? !nsx.equals(that.nsx) : that.nsx != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (nsx != null ? nsx.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public Collection<CartItemEntity> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItemEntity> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }

    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
