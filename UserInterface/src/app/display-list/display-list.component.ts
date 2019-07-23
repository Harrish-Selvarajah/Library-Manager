import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-display-list',
  templateUrl: './display-list.component.html',
  styleUrls: ['./display-list.component.css']
})
export class DisplayListComponent implements OnInit {
 
  books=[]

  
  constructor(private router: Router, private user: UserService, private httpClient:HttpClient) { }

  ngOnInit() {
    console.log("Im here gentleman")
    this.retrieve()
  }

  menuclick(): void {
    this.router.navigate(["menu"]);
  }

  logoutclick(): void {
    this.router.navigate([""]);
  }

  booksee(): void {
    this.router.navigate(["display-list"]);
  }

  dvdsee(): void {
    this.router.navigate(["app-dvdlist"]);
  }

  borrowclick(): void {
    this.router.navigate(["reader"]);
  }

  retrieve(): void {
    this.httpClient.get
    ('http://localhost:9000/bookg').toPromise().then(
      (res: any)=>{

        res.forEach(element => {
          this.books.push(element)
        });
        
        console.log("this is res")
        console.log(this.books)}).catch(err=>console.log(err));
  }

  removeclcik(a): void{
    console.log(a)
    const b = Object.assign({},this.books[a])
    console.log(b.isbn)
    this.books.splice(a,1)
    const isbn=b.isbn.toString()
    console.log(isbn)

    this.httpClient.delete
    ('http://localhost:9000/bookd/${isbn}').toPromise().then(
      (res:any)=>{
        console.log(res.data)
      }
    )
  }



  
}
