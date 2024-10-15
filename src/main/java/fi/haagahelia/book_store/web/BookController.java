package fi.haagahelia.book_store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @GetMapping("/index")
    public String requestMethodName() {
        return "index";
    }
    
}
