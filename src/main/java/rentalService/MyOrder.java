package rentalService;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="MyOrder_table")
public class MyOrder {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long productId;
        private Long rentalId;
        private int rentalQty;
        private String rentalStatus;
        private Long deliveryId;
        private String deliveryStatus;
        private String productName;


        /*
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }
        public Long getRentalId() {
            return rentalId;
        }

        public void setRentalId(Long rentalId) {
            this.rentalId = rentalId;
        }
        public Integer getRentalQty() {
            return rentalQty;
        }

        public void setRentalQty(Integer rentalQty) {
            this.rentalQty = rentalQty;
        }
        public String getRentalStatus() {
            return rentalStatus;
        }

        public void setRentalStatus(String rentalStatus) {
            this.rentalStatus = rentalStatus;
        }
        public Long getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(Long deliveryId) {
            this.deliveryId = deliveryId;
        }
        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }

        public String getProductName() {
            return this.productName;
        }
        public void setProductName(String productName) {
        this.productName = productName;
    }
    */


}
