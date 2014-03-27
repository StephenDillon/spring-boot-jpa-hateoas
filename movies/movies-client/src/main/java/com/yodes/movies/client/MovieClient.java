package com.yodes.movies.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.JsonPath;
import com.yodes.movies.api.model.Movie;

public class MovieClient implements CrudClient<Movie> {

	private String MOVIES_URL = "http://localhost:8080/movie";

	private String MOVIE_URL = MOVIES_URL + "/%s";

	private RestTemplate template = new RestTemplate();

	@Override
	public List<Movie> get() {
		String result = template.getForObject(MOVIES_URL, String.class);
		List<Movie> drives = JsonPath.read(result, "$.content");
		return drives;
	}

	@Override
	public Movie getById(String id) {
		String result = template.getForObject(String.format(MOVIE_URL, id), String.class);
		Movie drive = JsonPath.read(result, "$.content");
		return drive;
	}

	@Override
	public String create(Movie disk) {
		ResponseEntity<String> response = template.postForEntity(MOVIES_URL, disk, String.class);
		String location = response.getHeaders().get("Location").get(0);
		return location.substring(location.lastIndexOf('/') + 1);
	}

	@Override
	public void update(Movie disk) {
		template.postForEntity(String.format(MOVIE_URL, disk.getId()), disk, String.class);
	}

	@Override
	public void deleteById(String id) {
		template.delete(MOVIES_URL + "/" + id);
	}

}
