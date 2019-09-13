package com.fsd.spring.repository;

import com.fsd.spring.entity.Book;
import com.fsd.spring.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query("select s.references from Subject s where lower(subtitle) like %:subtitle%")
    List<Book> findBySubtitleContaining(@Param("subtitle") String subtitle);

    @Query("select s from Subject s where durationInHours =:durationInHours")
    List<Subject> findByDurationInHours(@Param("durationInHours") int durationInHours);

    @Modifying
    @Query("delete from Subject where lower(subtitle) like %:subtitle%")
    int deleteSubjectBySubtitleContaining(@Param("subtitle") String subtitle);

}
