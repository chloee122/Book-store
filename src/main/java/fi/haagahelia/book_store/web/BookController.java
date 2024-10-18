package fi.haagahelia.book_store.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.book_store.domain.Book;
import fi.haagahelia.book_store.domain.BookRepository;
import fi.haagahelia.book_store.domain.CategoryRepository;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {
    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    @GetMapping("/index")
    public String requestMethodName() {
        return "index";
    }
    
    @RequestMapping(value= {"/booklist"}) 
    public String studentList(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist"; }


    @RequestMapping("/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) brepository.findAll();
    }

    @RequestMapping("/book/{id}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId, Model model) {
        return (Optional<Book>) brepository.findById(bookId);
    }
    
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        brepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
    
    @PostMapping("/save") 
    public String saveBook(Book book){
        brepository.save(book); 
        return "redirect:booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", brepository.findById(bookId));
        return "editbook";
    }
}
