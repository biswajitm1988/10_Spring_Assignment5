package com.fsd.spring.dao;

import com.fsd.spring.entity.Book;
import com.fsd.spring.entity.Subject;
import com.fsd.spring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class SubjectDao {

    @Autowired
    private SubjectRepository subjectRepository;

	public boolean addSubject(Subject newSubject) throws Exception {
		subjectRepository.save(newSubject);
		return true;
	}

	public int getAllSubjectCount() throws Exception {
		Long subjectCount = subjectRepository.count();;
		return subjectCount.intValue();
	}

	public List<Book> searchForSubjects(String subtitle) throws Exception {
		List<Book> bookList = subjectRepository.findBySubtitleContaining(subtitle);
		return bookList;
	}

	public int deleteSubject(String subtitle) throws Exception {
		int results = subjectRepository.deleteSubjectBySubtitleContaining(subtitle);
		return results;
	}

	public Collection<Subject> getAllSubjectss() {
		List<Subject> subjectList = subjectRepository.findAll();
		return subjectList;
	}

    public List<Subject> searchBySuration(int searchDuration) {
		List<Subject> subjects = subjectRepository.findByDurationInHours(searchDuration);
		return subjects;
    }
}
