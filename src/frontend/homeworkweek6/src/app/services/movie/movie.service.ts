import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from 'src/app/models/Movie.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  public constructor(private http: HttpClient) { }

  public postMovie(movie: Movie): Observable<Movie> {
    return this.http
      .post<Movie>(`${environment.url}/movie`, movie);
  }
  public getMovies(): Observable<Movie[]> {
    return this.http
      .get<Movie[]>(`${environment.url}/movie`);
  }
}
