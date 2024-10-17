package fi.haagahelia.book_store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.book_store.domain.Book;
import fi.haagahelia.book_store.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {
    @Autowired
    private BookRepository brepository;

    @GetMapping("/index")
    public String requestMethodName() {
        return "index";
    }
    
    @RequestMapping(value= {"/booklist"}) public String studentList(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist"; }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        brepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @PostMapping("/save") public String saveBook(Book book){
        brepository.save(book); 
        return "redirect:booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", brepository.findById(bookId));
        return "editbook";
    }
    

}
