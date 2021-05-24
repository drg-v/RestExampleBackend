package com.example.demo.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Inhabitant;

@Repository
public class InhabitantDao implements AbstractDao<Inhabitant> {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public InhabitantDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Collection<Inhabitant> getAll() {
		return jdbcTemplate.query("SELECT hab_id, name, surname, patronymic, flat_id FROM inhabitant ORDER BY hab_id;", 
								  (rs, rowNum) -> new Inhabitant(rs.getInt("hab_id"),
										  						 rs.getString("name"), 
										  						 rs.getString("surname"), 
										  						 rs.getString("patronymic"), 
										  						 rs.getInt("flat_id")));
	}
	
	public void create(Inhabitant inhabitant) {
		Integer value = jdbcTemplate.queryForObject("SELECT MAX(hab_id) FROM inhabitant ;", Integer.class);
		jdbcTemplate.update("INSERT INTO inhabitant(hab_id, name, surname, patronymic, flat_id) VALUES(?, ?, ?, ?, ?);",
							value + 1,
							inhabitant.getName(),
							inhabitant.getSurname(),
							inhabitant.getPatronymic(),
							inhabitant.getFlat_id());
	}
	
	public Inhabitant read(Integer hab_id) {
		return jdbcTemplate.query("SELECT hab_id, name, surname, patronymic, flat_id FROM inhabitant WHERE hab_id=?;",
				(ResultSetExtractor<Inhabitant>) rs -> { rs.next();
											return new Inhabitant(rs.getInt("hab_id"), 
											rs.getString("name"), 
											rs.getString("surname"),
											rs.getString("patronymic"),
											rs.getInt("flat_id"));},
									hab_id);
	}
	
	public void update(Inhabitant inhabitant) {
		jdbcTemplate.update("UPDATE inhabitant SET name=?, surname=?, patronymic=?, flat_id=? WHERE hab_id=?;",
							inhabitant.getName(),
							inhabitant.getSurname(),
							inhabitant.getPatronymic(),
							inhabitant.getFlat_id(),
							inhabitant.getHab_id());
	}
	
	public void delete(Integer id) {
		System.out.println("DELETING" + id);
		jdbcTemplate.update("DELETE FROM inhabitant WHERE hab_id=?;",
							id);
	}
	
	
}
