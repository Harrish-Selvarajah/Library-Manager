import { Component, OnInit } from "@angular/core";
import { UserService } from "../user.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-dashboard",
  templateUrl: "./menu.component.html",
  styleUrls: ["./menu.component.css"]
})
export class menuComponent implements OnInit {
  constructor(private router: Router, private user: UserService) {}

  ngOnInit() {}
}
