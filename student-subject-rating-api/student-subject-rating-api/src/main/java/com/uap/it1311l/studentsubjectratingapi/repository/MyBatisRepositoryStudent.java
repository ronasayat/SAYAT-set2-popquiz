package com.uap.it1311l.studentsubjectratingapi.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.uap.it1311l.studentsubjectratingapi.models.Information;
import com.uap.it1311l.studentsubjectratingapi.models.Ratings;

@Mapper
public interface MyBatisRepositoryStudent {
	@Insert("INSERT INTO student_info(studentId, studentName, comment, averageGrade) VALUES (#{studentId}, #{studentName}, #{comment}, #{averageGrade})" + 
			"INSERT INTO student_ratings(code, name, grade) VALUES (#{code}, #{name}, #{grade})")
			public int insert (Information student_info);
			public int insert (Ratings student_ratings);
}
