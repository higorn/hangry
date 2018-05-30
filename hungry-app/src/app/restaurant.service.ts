import { Injectable } from '@angular/core';
import { Restaurant } from './model/restaurant';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { ApiResponse } from './model/api-response';

const RESTAURANTS: Restaurant[] = [
  { id: 1, name: 'Xis da Gringa' },
  { id: 2, name: 'Casa di Paolo' },
  { id: 3, name: 'Moreira Burger' },
];

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  private url = '/myproject/api/v1/restaurant'

  constructor(
    private http: HttpClient,
  ) { }

/*  getRestaurants(): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.url)
      .pipe(
        tap(resp => console.log(resp))
      );*/
/*      .pipe(
        tap(resp => {
          console.log(resp);
          // return restaurants.data as Restaurant[];
          return resp;
        }),
        catchError(this.handleError('getRestaurants', ApiResponse))
      );*/
  // }

  getRestaurants(): Observable<Restaurant[]> {
    return this.http.get(this.url)
      .pipe(
        map(resp => {
          console.log(resp);
          return resp['data'] as Restaurant[];
        })
      );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
