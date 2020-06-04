package pl.akademiaspringa.homeworkweek6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspringa.homeworkweek6.Models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
