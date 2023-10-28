package com.rbprogramming.orderservice.service;

import com.rbprogramming.orderservice.dto.OrderLineItemsDto;
import com.rbprogramming.orderservice.dto.OrderRequest;
import com.rbprogramming.orderservice.model.Order;
import com.rbprogramming.orderservice.model.OrderLineItems;
import com.rbprogramming.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = Optional.ofNullable(orderRequest.getOrderLineItemsDtosList())
                .map(orderLineItemsDtos -> orderLineItemsDtos.stream()
                        .map(this::mapToDto)
                        .toList()

                ).orElse(Collections.emptyList());


        order.setOrderLineItemsList(orderLineItems);
        // Call inventory service and place the order if product is in stock
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
