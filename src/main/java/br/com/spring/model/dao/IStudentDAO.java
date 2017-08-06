package br.com.spring.model.dao;

import java.util.List;

import br.com.spring.model.bean.Student;

/**
 * metodos de implementacao do student
 * 
 * @author fernando
 *
 */
public interface IStudentDAO {

	/**
	 * salvar student
	 * 
	 * @param student
	 */
	public void save(Student student);

	/**
	 * atualizar o student
	 * 
	 * @param student
	 */
	public void update(Student student);

	/**
	 * buscar student por id
	 * 
	 * @param id
	 * @return
	 */
	public Student find(int id);

	/**
	 * listar todos os students
	 * 
	 * @return
	 */
	public List<Student> findAll();

	/**
	 * apagar student
	 * 
	 * @param student
	 */
	public void delete(int id);

}
