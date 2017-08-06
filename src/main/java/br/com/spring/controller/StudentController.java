package br.com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.spring.model.bean.Student;
import br.com.spring.model.dao.IStudentDAO;

/**
 * Classe controlador Student
 * 
 * @author fernando
 *
 */
@Controller
public class StudentController {

	@Autowired
	private IStudentDAO iStudentDAO;

	/**
	 * redirencionando para a pagina de form do student
	 * 
	 * @param maps
	 * @return
	 */
	@RequestMapping("/")
	public String setupForm(Map<String, Object> maps) {
		maps.put("student", new Student());
		maps.put("studentAll", this.iStudentDAO.findAll());

		return "form-student";
	}

	/**
	 * metodo que recebe a acao do formulario, dependendo da acao
	 * o metodo verica essa acao e chama o metodo corresponde a acao
	 * escolhida no formulario sendo elas para salvar, alterar, 
	 * pesquisar e excluir 
	 * 
	 * @param student
	 * @param result
	 * @param action
	 * @param maps
	 * @return
	 */
	@RequestMapping(value="student.do", method=RequestMethod.POST)
	public String doAction(@ModelAttribute Student student,
			BindingResult result, @RequestParam String action,
			Map<String, Object> maps) {

		Student studentResult = new Student();
		
		switch (action.toLowerCase()) {
		
		case "add":
			this.iStudentDAO.save(student);
			break;
			
		case "edit":
			this.iStudentDAO.update(student);
			break;
			
		case "search":
			Student find = this.iStudentDAO.find(student.getId());
			studentResult = find!=null ? find : studentResult;
			break;
			
		case "delete":
			this.iStudentDAO.delete(student.getId());
			break;
		}
		
		maps.put("student", studentResult);
		maps.put("studentAll", this.iStudentDAO.findAll());
		
		return "form-student";
	}
}
