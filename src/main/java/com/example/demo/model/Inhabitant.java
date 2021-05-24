package com.example.demo.model;

public class Inhabitant {
	private Integer hab_id;
	private String name;
	private String surname;
	private String patronymic;
	private Integer flat_id;
	
	public Inhabitant(Integer hab_id, String name, String surname, String patronymic, Integer flat_id) {
		super();
		this.hab_id = hab_id;
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.flat_id = flat_id;
	}

	public Integer getHab_id() {
		return hab_id;
	}

	public void setHab_id(Integer hab_id) {
		this.hab_id = hab_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Integer getFlat_id() {
		return flat_id;
	}

	public void setFlat_id(Integer flat_id) {
		this.flat_id = flat_id;
	}
	
	@Override
	public String toString() {
		return "Inhabitant [hab_id=" + hab_id + ", name=" + name + ", surname=" + surname + ", patronymic=" + patronymic
				+ ", flat_id=" + flat_id + "]";
	}
	
}
