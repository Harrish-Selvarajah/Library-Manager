import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dvdlist',
  templateUrl: './dvdlist.component.html',
  styleUrls: ['./dvdlist.component.css']
})
export class DvdlistComponent implements OnInit {

  dvds=[]

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

  retrieve(): void {
    this.httpClient.get
    ('http://localhost:9000/dvdg').toPromise().then(
      (res: any)=>{

        res.forEach(element => {
          this.dvds.push(element)
        });
        console.log("this is res")
        console.log(this.dvds)}).catch(err=>console.log(err));
  }

  removeclcik(a): void{
    console.log(a)
    const b = Object.assign({},this.dvds[a])
    console.log(b.dvdid)
    this.dvds.splice(a,1)
    const dvdid=b.dvdid.toString()
    console.log(dvdid)

    this.httpClient.delete
    ('http://localhost:9000/dvdd/ :dvdid').toPromise().then(
      (res:any)=>{
        console.log(res.data)
      }
    )
  }


}
