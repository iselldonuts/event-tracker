package ru.iselldonuts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SquareController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/square")
    public Square square(@RequestParam(value = "number", defaultValue = "0") String content) {
        Double number = safeCastToDouble(content);
        return new Square(counter.incrementAndGet(), number * number);
    }

    private Double safeCastToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0.;
        }
    }
}

