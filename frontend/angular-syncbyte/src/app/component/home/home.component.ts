import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  registered: boolean = false;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
 this.router.params.subscribe(params =>{
   this.registered = params['value'];
 });
  }

}
