package webapp.product.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.product.dto.OrdersDTO;
import webapp.product.pojo.Orders;
import webapp.product.repository.OrdersRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
@Autowired
    private OrdersRepository ordersRepository;
@Autowired
    private ModelMapper modelMapper;

    public List<OrdersDTO> getAllOrders(){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return ordersRepository.findAll()
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }
    public void saveOrders(OrdersDTO ordersDTO){
        Orders orders = modelMapper.map(ordersDTO,Orders.class );
        ordersRepository.save(orders);
    }

    public OrdersDTO getOneByOrdNo(Integer ordNo){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return EntityToDTO(ordersRepository.findByOrdNo(ordNo));
    }


    private OrdersDTO EntityToDTO(Orders orders) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO = modelMapper.map(orders, OrdersDTO.class);
        return ordersDTO;
    }
}