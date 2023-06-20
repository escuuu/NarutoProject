import { HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GifServiceService {
  private key: string = '5zlCzaK5LUAXTqGc1HNKCgryBuJNhLEd';
  private urlGIF: string = 'https://api.giphy.com/v1/gifs/search'

  constructor(private http: HttpClientModule, private router: Router) { }

  
  getGifs() {
    const params = new HttpParams().set('api_key', this.key).set('q', 'Naruto')
  }

}
