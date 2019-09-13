package com.fsd.spring.helper;

import com.fsd.spring.dao.BookDao;
import com.fsd.spring.dao.SubjectDao;
import com.fsd.spring.entity.Book;
import com.fsd.spring.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectHelper {

	@Autowired
    private BookDao bookDao;

    @Autowired
    private SubjectDao subjectDao;

    public int deleteSubject(String deleteSubTitle) throws Exception {
        int SubCount = subjectDao.getAllSubjectCount();
        if (SubCount==0) {
            System.out.println("There are no subjects in the system");
            return SubCount;
        }
        int count = subjectDao.deleteSubject(deleteSubTitle);
        System.out.println("Number of records deleted : "+count);
        return SubCount;
    }

    public List<Book> searchBySubject(String subTitle) throws Exception {
        int SubCount = subjectDao.getAllSubjectCount();
        List<Book> bookDetailsList  = new ArrayList<Book>();
        if (SubCount==0) {
            System.out.println("There are no subjects in the system");
            return bookDetailsList;
        }
        bookDetailsList=subjectDao.searchForSubjects(subTitle);
        if(bookDetailsList.isEmpty()){
            System.out.println("no books found for your search : "+subTitle);
        }else{
            System.out.println("Matching Books :\n"+bookDetailsList);
        }
        return bookDetailsList;
    }

    public List<Subject> searchBySuration(String searchDuration) throws Exception {
        int SubCount = subjectDao.getAllSubjectCount();
        List<Subject> subDetailsList  = new ArrayList<>();
        if (SubCount==0) {
            System.out.println("There are no subjects in the system");
            return subDetailsList;
        }
        subDetailsList = subjectDao.searchBySuration(searchDuration);
        if(CollectionUtils.isEmpty(subDetailsList)){
            System.out.println("no Subject found for your search : "+searchDuration);
        }else{
            System.out.println("Matching Subjects :\n"+subDetailsList);
        }
        return subDetailsList;
    }

    public String transformToHtml(List<Subject> subjects) {
        if(CollectionUtils.isEmpty(subjects)){
            return "No Subject Found for the Search Key";
        }
        StringBuilder buf = new StringBuilder();
        buf.append("<html>" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th>Subject ID</th>" +
                "<th>Subject Title</th>" +
                "<th>DurationIn Hours</th>" +
                "</tr>");
        subjects.forEach(subject ->{
            buf.append("<tr><td>")
                    .append(subject.getSubjectId())
                    .append("</td><td>")
                    .append(subject.getSubtitle())
                    .append("</td><td>")
                    .append(subject.getDurationInHours())
                    .append("</td></tr>");
        });
        buf.append("</table>" +
                "</body>" +
                "</html>");
        return buf.toString();
    }
}
