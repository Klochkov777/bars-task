package priv.klochkov.constructionwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import priv.klochkov.constructionwork.dto.OrderDto;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.impl.OrderServiceImpl;

@RestController
@RequestMapping("/hello")
public class TestController {


    OrderServiceImpl orderService;

    @Autowired
    public TestController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getHello() {
        System.out.println("I am here");
        return "hello";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public OrderDto getPerson(@PathVariable("id") long id) {
        System.out.println("HELLO!!!!");
        OrderEntity order = orderService.getOrderById(id);
        OrderDto orderDto = new OrderDto(order.getId(), order.getCustomer().getName());
        return orderDto;
    }
}