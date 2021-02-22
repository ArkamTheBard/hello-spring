package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @PostMapping("helloLang") //this is createMessage lol
    @ResponseBody
    public String helloWithSelect(@RequestParam String name, @RequestParam String langs){
        if(langs.equals("fr")){
            return "Bonjour, " + name + '!';
        }else if(langs.equals("ger")){
            return "Hallo, " + name + '!';
        }else if(langs.equals("sp")){
            return "Hola, " + name + '!';
        }else if(langs.equals("jp")){
            return "こんにちは、 " + name  + '!';
        }else{
            return "Hello, " + name + '!';
        }
    }

    //Handles request of the form /hello/LaunchCode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("select")
    @ResponseBody
    public String helloSelect(){
        return "<html>" +
                "<body>" +
                "<form action='helloLang' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='langs'>" +
                "<option value='eng'>English</option>" +
                "<option value='fr'>French</option>" +
                "<option value='ger'>German</option>" +
                "<option value='sp'>Spanish</option>" +
                "<option value='jp'>Japanese</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
