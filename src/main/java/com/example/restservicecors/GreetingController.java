package com.example.restservicecors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/greetings")
    public Greeting greeting(@RequestParam(required = false, value="name",defaultValue = "World") String name){
        System.out.println("========= get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greetings1")
    public Greeting greeting1(){
        System.out.println("========= get greeting1 ====");
        return new Greeting();
    }
}
