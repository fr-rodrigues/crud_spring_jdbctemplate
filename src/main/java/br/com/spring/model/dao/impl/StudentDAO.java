package br.com.spring.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.model.bean.Student;
import br.com.spring.model.dao.IStudentDAO;

/**
 * Classe que implementa os metodos do Student
 * @see IStudentDAO
 * @author fernando
 *
 */
@Repository
public class StudentDAO implements IStudentDAO{

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public StudentDAO(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	@Transactional
	public void save(Student student) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		this.jdbc.update("insert into student(stu_nome, stu_cpf) values (:name, :cpf)", params);
	}

	@Transactional
	public void update(Student student) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		this.jdbc.update("update student set stu_nome=:name, stu_cpf=:cpf where stu_id=:id", params);
	}

	public Student find(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return this.jdbc.queryForObject("select * from student where stu_id =:id", params, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Student student = new Student();
				student.setId(rs.getInt("stu_id"));
				student.setName(rs.getString("stu_nome"));
				student.setCpf(rs.getString("stu_cpf"));
				
				return student;
			}
		});
	}

	public List<Student> findAll() {
		
		return this.jdbc.query("select * from student", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Student student = new Student();
				student.setId(rs.getInt("stu_id"));
				student.setName(rs.getString("stu_nome"));
				student.setCpf(rs.getString("stu_cpf"));
				
				return student;
			}
		});
	}

	@Transactional
	public void delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		this.jdbc.update("delete from student where stu_id=:id ", params);
	}

}
