import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../model/restaurant';
import { RestaurantService } from '../restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {
  restaurants: Restaurant[];
  selected: Restaurant;

  constructor(
    private service: RestaurantService,
  ) { }

  ngOnInit() {
    this.getRestaurants();
  }

  onSelect(restaurant: Restaurant) {
    this.selected = restaurant;
    this.service.update(restaurant).subscribe(resp => {
      restaurant.likes = resp;
    });
  }

  private getRestaurants() {
    this.service.getRestaurants().subscribe(restaurans => this.restaurants = restaurans);
  }
}
