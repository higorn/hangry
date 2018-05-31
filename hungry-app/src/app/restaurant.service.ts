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
  private baseUrl = '/myproject/api/v1/restaurants'

  constructor(
    private http: HttpClient,
  ) { }

  getRestaurants(): Observable<Restaurant[]> {
    return this.http.get(this.baseUrl)
      .pipe(
        map(resp => {
          console.log(resp);
          return resp['data'] as Restaurant[];
        }),
        catchError(this.handleError('getRestaurants', []))
      );
  }

  update(restaurant: Restaurant): Observable<number> {
    return this.http.put(`${this.baseUrl}/like/${restaurant.id}`, null)
      .pipe(
        map(response => {
          console.log(response);
          return response['data'] as number;
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
