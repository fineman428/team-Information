package rentalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import rentalService.config.kafka.KafkaProcessor;

import java.util.List;

@Service
public class MyOrderViewHandler {


    @Autowired
    private MyOrderRepository myOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRentaled_then_CREATE_1 (@Payload Rentaled rentaled) {
        try {
            if (rentaled.isMe()) {
                // view 객체 생성
                MyOrder myOrder = new MyOrder();
                // view 객체에 이벤트의 Value 를 set 함
                myOrder.setRentalId(rentaled.getId());
                myOrder.setRentalQty(rentaled.getQty());
                myOrder.setProductId(rentaled.getProductId());
                myOrder.setRentalStatus(rentaled.getStatus());
                myOrder.setProductName(rentaled.getProductName());
                // view 레파지 토리에 save
                myOrderRepository.save(myOrder);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_1(@Payload Delivered delivered) {
        try {
            if (delivered.isMe()) {
                // view 객체 조회
                List<MyOrder> myOrderList = myOrderRepository.findByRentalId(delivered.getRentalId());
                for(MyOrder myOrder : myOrderList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myOrder.setDeliveryId(delivered.getId());
                    myOrder.setDeliveryStatus(delivered.getStatus());
                    myOrder.setRentalStatus(delivered.getStatus());
                    // view 레파지 토리에 save
                    myOrderRepository.save(myOrder);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_1(@Payload RentalCanceled rentalCanceled) {
        try {
            if (rentalCanceled.isMe()) {
                // view 객체 조회
                List<MyOrder> myOrderList = myOrderRepository.findByRentalId(rentalCanceled.getId());
                for(MyOrder myOrder : myOrderList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myOrder.setRentalStatus(rentalCanceled.getStatus());
                    myOrder.setDeliveryStatus(rentalCanceled.getStatus());
                    // view 레파지 토리에 save
                    myOrderRepository.save(myOrder);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRentalCanceled_then_DELETE_1(@Payload RentalCanceled rentalCanceled) {
        try {
            if (rentalCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                myOrderRepository.deleteByRentalId(rentalCanceled.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}