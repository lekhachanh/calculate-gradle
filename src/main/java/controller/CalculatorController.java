package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/calculate")
    public String calculate(@RequestParam (name = "firstOperand", defaultValue = "0")double firstOperand,
                            @RequestParam (name = "secondOperand", defaultValue = "0")double secondOperand,
                            @RequestParam (name = "operator", defaultValue = "+") String operator, Model model){
        double result = 0;
        switch (operator) {
            case "Addition(+)":
                result =  firstOperand + secondOperand;
                operator = "Addition";
                break;
            case "Subtraction(-)":
                result = firstOperand - secondOperand;
                operator = "Subtraction";
                break;
            case "Multiplication(*)":
                result = firstOperand * secondOperand;
                operator = "Multiplication";
                break;
            case "Division(/)":
                result = firstOperand / secondOperand;
                operator = "Division";
                break;
        }
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("operator", operator);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("result", result);
        return "index";
    }

}
