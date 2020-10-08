package rentalService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyOrderRepository extends CrudRepository<MyOrder, Long> {

    List<MyOrder> findByRentalId(Long rentalId);

        void deleteByRentalId(Long rentalId);
}