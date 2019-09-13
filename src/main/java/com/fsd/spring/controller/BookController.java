package com.fsd.spring.controller;

import com.fsd.spring.entity.Book;
import com.fsd.spring.entity.Subject;
import com.fsd.spring.helper.BookHelper;
import com.fsd.spring.helper.SubjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookHelper bookHelper;

    @Autowired
    private SubjectHelper subjectHelper;

    @GetMapping("/home")
    public ModelAndView index() throws IOException {
        System.out.println("Book Controller index");
        return new ModelAndView("home");
    }

    @GetMapping("/searchWithSubTitle")
    @ResponseBody
    public String searchWithSubTitle(@RequestParam(name = "searchSubTitle") String subTitle) throws Exception {
        System.out.println("Book Controller searchWithSubTitle >> "+subTitle);
        List<Book> bookList = subjectHelper.searchBySubject(subTitle);
        return bookHelper.transformToHtml(bookList);
    }

    @GetMapping("/searchSubjectByDur")
    @ResponseBody
    public String searchSubjectByDur(@RequestParam(name = "searchDuration") String searchDuration) throws Exception {
        System.out.println("Book Controller searchDuration >> "+searchDuration);
        List<Subject> subjects = subjectHelper.searchBySuration(searchDuration);
        return subjectHelper.transformToHtml(subjects);
    }

    @GetMapping("/searchWithBookTitle")
    @ResponseBody
    public String searchWithBookTitle(@RequestParam(name = "searchBookTitle") String bookTitle) throws Exception {
        System.out.println("Book Controller searchWithBookTitle >> "+bookTitle);
        List<Book> bookList = bookHelper.searchByBook(bookTitle);
        return bookHelper.transformToHtml(bookList);
    }

    @PostMapping("/deleteWithSubjectTitle")
    @ResponseBody
    public String deleteWithSubjectTitle(@RequestParam(name = "deleteSubTitle") String deleteSubTitle) throws Exception {
        System.out.println("Book Controller deleteWithSubjectTitle >> "+deleteSubTitle);
        int count = subjectHelper.deleteSubject(deleteSubTitle);
        return String.valueOf(count).concat(" records deleted");
    }

    @PostMapping("/deleteWithBookTitle")
    @ResponseBody
    public String deleteWithBookTitle(@RequestParam(name = "deleteBookTitle") String deleteBookTitle) throws Exception {
        System.out.println("Book Controller deleteWithBookTitle >> "+deleteBookTitle);
        int count = bookHelper.deleteBook(deleteBookTitle);
        return String.valueOf(count).concat(" records deleted");
    }

    @PostMapping("/addBook")
    @ResponseBody
    public String addBook(@ModelAttribute Book book) throws Exception {
        System.out.println("Book Controller deleteWithBookTitle >> "+book);
        long bookId = bookHelper.addBook(book);
        return "Number ".concat(String.valueOf(bookId)).concat(" book added");
    }
}