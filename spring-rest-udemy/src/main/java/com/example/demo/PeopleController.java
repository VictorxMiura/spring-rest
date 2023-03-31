package com.example.demo;


import com.example.demo.exceptionmodels.TesteException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class PeopleController {

    @GetMapping("sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
            throw new TesteException("Please set a numeric value");
        }
    Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;

    }

    public Double convertToDouble(String strNumber) {
        if (strNumber == null) return  0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble((number));
        return 0d;
    }


    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
