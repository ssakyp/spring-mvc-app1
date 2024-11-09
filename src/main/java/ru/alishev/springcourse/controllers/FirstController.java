package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
//        //HttpServletRequest => without params => null
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "operation")String operator,
                             Model model){

        switch (operator){
            case "multiplication":
                model.addAttribute("message", "The result of multiplication is " + a*b);
                break;
            case "addition":
                model.addAttribute("message", "The result of addition is " + (a+b));
                break;
            case "subtraction":
                model.addAttribute("message", "The result of subtraction is " + (a-b));
                break;
            case "division":
                model.addAttribute("message", "The result of division is " + a/(double)b);
                break;
        }
        return "first/calculator";
    }
}
