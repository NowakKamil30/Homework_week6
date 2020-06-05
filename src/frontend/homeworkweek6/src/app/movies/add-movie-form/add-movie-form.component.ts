import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MovieService } from 'src/app/services/movie/movie.service';
import { Movie } from 'src/app/models/Movie.model';

@Component({
  selector: 'app-add-movie-form',
  templateUrl: './add-movie-form.component.html',
  styleUrls: ['./add-movie-form.component.scss']
})
export class AddMovieFormComponent implements OnInit {
  public addMovieForm: FormGroup;
  public isLoading = false;
  public isError = false;
  public isSuccess = false;

  public constructor(private movieService: MovieService) {
    this.addMovieForm = new FormGroup({
      name: new FormControl(null, [
        Validators.min(5),
        Validators.max(20),
        Validators.required
      ]),
      producer: new FormControl(null, [
        Validators.min(5),
        Validators.max(20),
        Validators.required
      ]),
      year: new FormControl(null, [
        Validators.min(4),
        Validators.required
      ]),
      user: new FormGroup({
        firstName: new FormControl(null, [
          Validators.min(5),
          Validators.max(20),
          Validators.required
        ]),
        lastName: new FormControl(null, [
          Validators.min(5),
          Validators.max(20),
          Validators.required
        ]),
        email: new FormControl(null, [
          Validators.min(5),
          Validators.max(20),
          Validators.email,
          Validators.required
        ]),
      })
    });
   }

  public ngOnInit(): void {}

  public onSubmit(): void {
    this.isError = false;
    this.isSuccess = false;
    this.isLoading = true;
    this.movieService
      .postMovie(this.addMovieForm.value as Movie)
      .subscribe(() => {
        this.isSuccess = true;
        this.isLoading = false;
      }, error => {
        this.isError = true;
        this.isLoading = false;
      });
    this.addMovieForm.reset();
  }

}
