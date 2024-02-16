package it.degroup.ex1.controller;

import java.util.List;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import it.degroup.ex1.dao.BookDao;
import it.degroup.ex1.dao.BookDaoImpl;
import it.degroup.ex1.models.Book;
import it.degroup.ex1.models.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private final BookService bServ;
	
	private final BookDao bDao;
	
	public BookController(BookService bServ, BookDao bDao) {
		super();
		this.bServ = bServ;
		this.bDao = bDao;
	}
	
	@GetMapping("/viewBooks")
	public String viewBooks(Model model) {
		//		model.addAttribute("books", bServ.getBooks());
		model.addAttribute("books", bDao.findAllBook());
		return "view-books";
	}
	@GetMapping("/addBook")
	public String addBookView(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}
	@PostMapping("/addBook")
	public RedirectView addBook(@ModelAttribute("book") Book book,RedirectAttributes redirectAttributes) {
		final RedirectView  redW=new RedirectView ("/book/addBook",true);
		Book savedBook=bDao.addBook(book);
		redirectAttributes.addFlashAttribute("savedBook",savedBook);
		redirectAttributes.addFlashAttribute("addBookSuccess",true);
		return redW;
	}
	@GetMapping("/getSingleBook")
	public RedirectView getSingleBook(@ModelAttribute("bookisbn") Book bookisbn, RedirectAttributes redirectAttributes) {
		final RedirectView  redW=new RedirectView ("/book/addBook",true);
		Book book=bDao.findByName(bookisbn.getIsbn());
		redirectAttributes.addFlashAttribute("bookRequired",book);
		redirectAttributes.addFlashAttribute("getSingleBook",true);
		return redW;
	}
	@GetMapping("/retriveBooks")
	public String retriveBooks(@RequestParam(value = "_", required = false) String ignoredParam) {
		List<Book> list= bDao.findAllBook();
		Gson gson=new Gson();
		String jsonData=gson.toJson(list);
		System.out.println(jsonData);
		return jsonData;
	}
}
