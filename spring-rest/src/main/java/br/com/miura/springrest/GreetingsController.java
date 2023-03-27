package br.com.miura.springrest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingsController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greetings greetings(
            @RequestParam(value = "name", defaultValue = "world")
            String name
    ) {
        return new Greetings(counter.incrementAndGet(),String.format(template,name));
    }


}
