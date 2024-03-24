package com.codegym.project02.repository;

import com.codegym.project02.model.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieTheaterRepository extends JpaRepository<MovieTheater,Long> {

}
