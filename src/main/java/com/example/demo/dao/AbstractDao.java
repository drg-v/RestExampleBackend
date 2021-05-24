package com.example.demo.dao;

import java.util.Collection;

public interface AbstractDao<T> {
	public Collection<T> getAll();
	public void create(T inhabitant);
	public void update(T inhabitant);
	public T read(Integer hab_id);
	public void delete(Integer hab_id);

}
