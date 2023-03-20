package com.mohanmmohadikar.orderservice.service;

import com.mohanmmohadikar.orderservice.dto.OrderLineItemsDto;import com.mohanmmohadikar.orderservice.dto.OrderRequest;import com.mohanmmohadikar.orderservice.model.Order;
import com.mohanmmohadikar.orderservice.model.OrderLineItems;
import com.mohanmmohadikar.orderservice.repository.OrderRepository;import java.util.List;import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  public void placeOrder(OrderRequest orderRequest) {
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItems> orderLineItems =  orderRequest.getOrderLineItemsDtoList()
        .stream()
        .map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
        .toList();

    order.setOrderLineItemsList(orderLineItems);

    orderRepository.save(order);
  }

  private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setPrice(orderLineItemsDto.getPrice());
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
    return orderLineItems;
  }
}
