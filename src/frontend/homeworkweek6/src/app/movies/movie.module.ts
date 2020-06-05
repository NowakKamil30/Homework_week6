import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MoviesComponent } from './movies/movies.component';
import { ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { AddMovieFormComponent } from './add-movie-form/add-movie-form.component';
import { MovieListComponent } from './movie-list/movie-list.component';



@NgModule({
  declarations: [
    MoviesComponent,
    AddMovieFormComponent,
    MovieListComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule
  ],
  exports: [
    MoviesComponent
  ]
})
export class MovieModule { }
