package star.demo.jdbc.service;

import star.demo.jdbc.model.Books;

import java.util.List;

public interface IBooksService {


    public int addBooks(Books books);

    public int updateBooks(Books books);

    public int deleteBooksById(int bid);

    public Books selectBooksById(int bid);

    public List<Books> selectAllBooks();


}