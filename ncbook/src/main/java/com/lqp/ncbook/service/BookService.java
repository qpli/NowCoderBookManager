package com.lqp.ncbook.service;

import com.lqp.ncbook.dao.BookDao;
import com.lqp.ncbook.model.Book;
import com.lqp.ncbook.model.enums.BookStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.selectAll();
    }

    public int addBooks(Book book) {
        return bookDao.addBook(book);
    }

    public void delectBooks(int id)
    {
        bookDao.updateBookStatus(id, BookStatusEnum.NORMAL.getValue());
    }


}
