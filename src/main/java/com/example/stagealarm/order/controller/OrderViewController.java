package com.example.stagealarm.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class OrderViewController {

    @GetMapping("myOrders")
    public String viewMyOrders(){
        return "content/item/myOrders";
    }
}
