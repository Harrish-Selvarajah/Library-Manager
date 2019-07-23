import { Component, OnInit, NgModule } from '@angular/core';
import { Book } from '../book.module';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { from } from 'rxjs';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';




@Component({
  selector: 'app-dashboard',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})


export class AddBookComponent implements OnInit  {
  books = [];
 

  //log(x) { console.log(x); }
  
  constructor(private router: Router, private user: UserService, private httpClient:HttpClient, private myFirstService : UserService){}

  ngOnInit() {
   
  }
  
//   get currentBook(){
//    return JSON.stringify(this.model);
// }
   menuclick(): void {
    this.router.navigate(["menu"]);
  }

  logoutclick(): void {
    this.router.navigate([""]);
  }

   add(form: NgForm) {

    let headers = new HttpHeaders({
      'Content-Type' : 'application/json'});
      let option = { headers : headers };

     let newBook = new Book(form.value.isbn,form.value.title,form.value.sector,form.value.publidate,form.value.author,form.value.publisher,form.value.noofpages);
     this.books.push(newBook);  
     console.log(newBook)
    
     this.httpClient.post
     ('http://localhost:9000/bookp', newBook, {headers:headers}).toPromise().then(
       (res: any)=>{
         console.log(res)}).catch(err=>console.log(err));
  }
}



 

  


