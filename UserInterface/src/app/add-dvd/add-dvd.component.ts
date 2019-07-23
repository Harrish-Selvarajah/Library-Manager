import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { Dvd } from '../dvd.module';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'add-dvds',
  templateUrl: './add-dvd.component.html',
  styleUrls: ['./add-dvd.component.css']
})
export class AddDvdComponent implements OnInit {
  
  
  
  dvds = [];
  
  constructor(private router: Router,private httpClient:HttpClient, private user: UserService){}

  ngOnInit() {
  }

  menuclick(): void {
    this.router.navigate(["menu"]);
  }

  logoutclick(): void {
    this.router.navigate([""]);
  }

  add(form: NgForm)  {

    let headers = new HttpHeaders({
      'Content-Type' : 'application/json'});
      let option = { headers : headers };

     let newDvd = new Dvd(form.value.dvdid,form.value.titled,form.value.sector,form.value.availang,form.value.sub,form.value.producer,form.value.actors);
     this.dvds.push(newDvd);  
    
     this.httpClient.post
     ('http://localhost:9000/dvdp', newDvd, {headers:headers}).toPromise().then(
       (res: any)=>{
         console.log(res)}).catch(err=>console.log(err));
  }

}
