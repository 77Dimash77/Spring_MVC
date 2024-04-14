package kz.dim.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam (value = "surname", required = false) String surname, Model model){

       // System.out.println(name + " " + surname);
        model.addAttribute("message","Hello" + name + " " + surname);

return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model){
double result;
switch (action){
    case  "mult":
        result = a * b;
        break;
    case  "del":
        result = a /(double) b;
        break;
    case  "plus":
        result = a + b;
        break;
    case  "minus":
        result = a - b;
        break;

    default: result = 0;

}
model.addAttribute("result", result);


        return "first/calculator";
    }
}
