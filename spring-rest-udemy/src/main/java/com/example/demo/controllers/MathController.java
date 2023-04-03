package com.example.demo.controllers;


import com.example.demo.convertoperations.NumberConverter;
import com.example.demo.exceptionmodels.TesteException;
import com.example.demo.mathoperations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class MathController {

    private Operation operation = new Operation();


    @GetMapping("sum/{numberOne}/{numberTwo}")
    public double soma(@PathVariable ("numberOne") String numberOne,
                       @PathVariable ("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new TesteException("Please set a numeric value");
        }
        return operation.Soma(NumberConverter.convertDouble(numberOne) ,  NumberConverter.convertDouble(numberTwo));
    }



    @GetMapping("sub/{numberOne}/{numberTwo}")
    public double Sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws  Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
        throw new TesteException("Please set a numeric value");
    }
        return operation.Subtração(NumberConverter.convertDouble(numberOne) ,  NumberConverter.convertDouble(numberTwo));
    }



    @GetMapping("div/{numberOne}/{numberTwo}")
    public double Div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws  TesteException {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
        throw new TesteException("Please set a numeric value");
    }
        return operation.Divisão(NumberConverter.convertDouble(numberOne) ,  NumberConverter.convertDouble(numberTwo));
    }



    @GetMapping("mult/{numberOne}/{numberTwo}")
    public Double Mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws  Exception {if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
        throw new TesteException("Please set a numeric value");
    }
        return operation.Multiplicação(NumberConverter.convertDouble(numberOne) ,  NumberConverter.convertDouble(numberTwo));
    }



    @GetMapping("med/{numberOne}/{numberTwo}")
    public Double Med(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws  Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
        throw new TesteException("Please set a numeric value");
    }
        return operation.Media(NumberConverter.convertDouble(numberOne) ,  NumberConverter.convertDouble(numberTwo));
    }

    @GetMapping("rai/{number}")
    public Double rai(
            @PathVariable("number") String number
    ) throws  Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new TesteException("Please set a numeric value! ");
        }
        return operation.raiz(NumberConverter.convertDouble(number));
    }

}
