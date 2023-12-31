package com.rbprogramming.orderservice.controller;

        import com.rbprogramming.orderservice.dto.OrderRequest;
        import com.rbprogramming.orderservice.service.OrderService;
        import lombok.RequiredArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("The return of request: {}", orderRequest);
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }
}
