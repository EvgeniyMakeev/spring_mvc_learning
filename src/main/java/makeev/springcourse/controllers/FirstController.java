package makeev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("massage", "Hello, " + name + " " + surname + "!");
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {
        int result = 0;
        char actionChar = ' ';
        switch (action.toLowerCase()) {
            case "multi" -> {
                result = a * b;
                actionChar = '*';
            }
            case "add" -> {
                result = a + b;
                actionChar = '+';
            }
            case "sub" -> {
                result = a - b;
                actionChar = '-';
            }
            case "div" -> {
                result = a / b;
                actionChar = '/';
            }
        }
        model.addAttribute("answer",
                a + " " + actionChar + " " + b + " = " + result);
        return "first/calculator";
    }
}
