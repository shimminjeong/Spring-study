package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model ){
        model.addAttribute("data","hello!");
        return "hello";
    }

//    <html>
//    <body>
//    <p>hello gogo!!</p>
//    </body>
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //"hello spring"
    @GetMapping("hello-string")
    @ResponseBody //http의 body부분에 이 내용을 직접 넣어주겠다. 값만 그대로 넘겨줌
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    //{"name":"gogo!!"}
    @GetMapping("hello-api")
    @ResponseBody //응답을 json으로 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    }
}
