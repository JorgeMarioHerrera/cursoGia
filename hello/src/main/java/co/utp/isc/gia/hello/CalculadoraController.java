/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utp.isc.gia.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mario
 */
@RestController
@RequestMapping("calc")
public class CalculadoraController {
    
    @GetMapping("/suma")
    public String suma(@RequestParam("num1") Integer num1,
        @RequestParam("num2") Integer num2) {        
        Integer res;
        res = num1 + num2;
        return String.format("El resultado de la suma es : %s ",  res);
    }
    @GetMapping("/resta")
    public String resta(@RequestParam("num1") Integer num1,
        @RequestParam("num2") Integer num2) {        
        Integer res;
        res = num1 - num2;
        return String.format("El resultado de la suma es : %s ",  res);
    }
    @GetMapping("/multiplicacion")
    public String multiplicacion(@RequestParam("num1") Integer num1,
        @RequestParam("num2") Integer num2) {        
        Integer res;
        res = num1 * num2;
        return String.format("El resultado de la suma es : %s ",  res);
    }
    @GetMapping("/division")
    public String division(@RequestParam("num1") Float num1,
        @RequestParam("num2") Float num2) {        
        Float res;
        if (num2 == 0 || num1 == 0) {
            return ("No se permiten divisiones con cero");
        }else {
            res = num1 / num2;
        return String.format("El resultado de la suma es : %s ",  res);
        }
        
    }
}
