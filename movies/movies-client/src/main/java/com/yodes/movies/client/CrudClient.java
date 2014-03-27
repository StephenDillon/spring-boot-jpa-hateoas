package com.yodes.movies.client;

import java.util.List;

public interface CrudClient<T> {

	public List<T> get();

	public T getById(String id);

	public String create(T resource);

	public void update(T resource);

	public void deleteById(String id);

}
