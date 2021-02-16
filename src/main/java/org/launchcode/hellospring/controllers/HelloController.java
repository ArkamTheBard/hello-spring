package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @PostMapping("helloLang") //this is createMessage lol
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
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" + //submit request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("select")
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

}
