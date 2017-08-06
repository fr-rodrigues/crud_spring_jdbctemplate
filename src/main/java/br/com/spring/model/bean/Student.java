package br.com.spring.model.bean;

/**
 * Classe modelo student
 * 
 * @author fernando
 *
 */
public class Student {

	private int id;
	private String name;
	private String cpf;

	/**
	 * gets and sets
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
