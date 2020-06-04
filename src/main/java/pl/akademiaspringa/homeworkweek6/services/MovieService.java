package pl.akademiaspringa.homeworkweek6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiaspringa.homeworkweek6.Models.Movie;
import pl.akademiaspringa.homeworkweek6.repositories.MovieRepository;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Iterable<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    public Optional<Movie> postMovie(Movie movie) {
        return Optional.of(movieRepository.save(movie));
    }

    public Optional<Movie> deleteById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            movieRepository.deleteById(id);
            return movieOptional;
        }
        return movieOptional;
    }
}
