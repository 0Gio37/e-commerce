package fr.cda.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductId implements Serializable {
    @Column(name = "fk_product_id")
    private Long productId;

    @Column(name = "fk_order_id")
    private Long orderId;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}