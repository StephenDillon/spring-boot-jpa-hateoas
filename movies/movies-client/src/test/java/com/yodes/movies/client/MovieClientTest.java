package com.yodes.movies.client;

import junit.framework.TestCase;

import org.junit.Test;

import com.yodes.movies.api.model.Movie;

public class MovieClientTest {

	private MovieClient client = new MovieClient();

	@Test
	public void testCRUD() {
		String id = testAddMovie();
		Movie drive = testGetById(id);
		testUpdateMovie(drive);
		testDeleteMovie(id);
	}

	private String testAddMovie() {
		int count = getCount();
		Movie movie = new Movie();
		movie.setName("The Matrix");
		String id = client.create(movie);
		TestCase.assertNotNull(id);
		TestCase.assertEquals(count + 1, getCount());
		return id;
	}

	private Movie testGetById(String id) {
		Movie movie = client.getById(id);
		TestCase.assertNotNull(movie);
		TestCase.assertEquals("The Matrix", movie.getName());
		return movie;
	}

	private void testUpdateMovie(Movie movie) {
		movie.setName("The Matrix Reloaded");
		int count = getCount();
		client.update(movie);
		TestCase.assertEquals("The Matrix Reloaded", movie.getName());
		TestCase.assertEquals(count, getCount());
	}

	private void testDeleteMovie(String id) {
		int count = getCount();
		client.deleteById(id);
		TestCase.assertEquals(count - 1, getCount());
	}

	private int getCount() {
		return client.get().size();
	}

}
