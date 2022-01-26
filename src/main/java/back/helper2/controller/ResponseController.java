package back.helper2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responseCode")
public class ResponseController {

    @GetMapping("/")
    public String func(@RequestParam String code, @RequestParam String scope, @RequestParam String client_info, @RequestParam String state){
        System.out.println(code);
        System.out.println(scope);

        return "hi";
    }
}
