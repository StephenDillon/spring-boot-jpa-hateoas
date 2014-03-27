package com.yodes.movies.service.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yodes.movies.api.model.Movie;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
public interface MovieRestRepository extends PagingAndSortingRepository<Movie, Long> {

}
