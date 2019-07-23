import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { UserService } from "../../user.service";
import { HttpClientModule } from '@angular/common/http';
import { HttpClient} from '@angular/common/http';
//import { Post } from './post';

@Component({
  selector: "app-menu-page",
  templateUrl: "./menu-page.component.html",
  styleUrls: ["./menu-page.component.css"]
})
export class MenuPageComponent implements OnInit {
  [x: string]: any;
  constructor(private router: Router, private user: UserService,private http: HttpClient) {}

  ngOnInit() {}

  addbookclick(): void {
    this.router.navigate(["add-book"]);
  }

  adddvdclick(): void {
    this.router.navigate(["add-dvd"]);
  }

  deleteitemclick(): void {
    this.router.navigate(["deleteitem"]);
  }

  manageitem(): void {
    this.router.navigate(["display-list"]);
  }

  reportclick(): void {
    this.router.navigate(["report"]);
  }

  readerloginclick(): void {
    this.router.navigate(["reader"]);
  }

  logoutclick(): void {
    this.router.navigate([""]);
  }

  getPosts(){
    this.httpClient.get
    ('http://localhost:9000/tests').toPromise().then(
      (res: any)=>{
        console.log(res)}).catch(err=>console.log(err));
  }

  

  

  }

