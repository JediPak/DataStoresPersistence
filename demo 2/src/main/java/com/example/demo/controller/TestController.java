package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/test")
public class TestController {

   @GetMapping
   public String test(){
      return "Data Structures and Persistence are pretty good.";
   }
}