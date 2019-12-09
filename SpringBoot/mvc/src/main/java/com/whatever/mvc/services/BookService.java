package com.whatever.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.whatever.mvc.models.Book;
import com.whatever.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
	private final BookRepository bookRepository;
	

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBookcopy(long id, String title, String desc, String lang, int numOfPages) {
    	Book book = findBook(id);
    	
    	book.setTitle(title);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
    	
    	Book b = bookRepository.save(book);
    	
    	return b;
    }
    
    public void deleteBook(long id) {
    	bookRepository.deleteById(id);
    }
    
    
    
    
    
    
    
}
