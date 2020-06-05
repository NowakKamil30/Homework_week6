package pl.akademiaspringa.homeworkweek6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspringa.homeworkweek6.Models.Movie;
import pl.akademiaspringa.homeworkweek6.aspects.SendEmail;
import pl.akademiaspringa.homeworkweek6.services.MovieService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Movie>> getAllMovie() {
        List<Movie> movieList = movieService.getAllMovie();
        if(movieList.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> optionalMovie = movieService.getMovieById(id);
        return optionalMovie
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @SendEmail
    @PostMapping()
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        Optional<Movie> movieOptional = movieService.postMovie(movie);
        return movieOptional
                .map(movieItem -> ResponseEntity.status(201).body(movieItem))
                .orElse(ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovieById(@PathVariable Long id) {
        Optional<Movie> movieOptional = movieService.deleteById(id);
        return movieOptional
                .map(movie -> ResponseEntity.accepted().body(movie))
                .orElse(ResponseEntity.notFound().build());
    }
}
