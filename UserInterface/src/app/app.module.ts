import { BrowserModule } from "@angular/platform-browser";
import { NgModule, Component } from "@angular/core";
import { FormsModule, NgModel } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./header/header.component"
import { FooterComponent } from "./footer/footer.component";
import { menuComponent } from "./menu/menu.component";
import { RouterModule, Routes } from "@angular/router";
import { UserService } from "./user.service";
import { AuthguardGuard } from "./authguard.guard";
import { MenuPageComponent } from "./menu/menu-page/menu-page.component";
import { AddBookComponent } from "./add-book/add-book.component";
import { CommonModule } from "@angular/common";
import { LoginformComponent } from "./loginform/loginform.component";
import { AddDvdComponent } from './add-dvd/add-dvd.component';
import { DisplayListComponent } from './display-list/display-list.component';
import { ReaderComponent } from './reader/reader.component';
import { DvdlistComponent } from './dvdlist/dvdlist.component';




const appRoutes: Routes = [
  {
    path: "",
    component: LoginformComponent
  },
  {
    path: "menu",
    canActivate: [AuthguardGuard],
    component: menuComponent
  },

  {
    path: "add-book",
    component: AddBookComponent
  },
  
  {
    path: "add-dvd",
    component: AddDvdComponent
  },

  {
    path: "display-list",
    component: DisplayListComponent
  },

  {
    path: "reader",
    component: ReaderComponent
  },

  {
    path: "app-dvdlist",
    component: DvdlistComponent
  },

  

  
  
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginformComponent,
    FooterComponent,
    menuComponent,
    MenuPageComponent,
    AddBookComponent,
    AddDvdComponent,
    DisplayListComponent,
    ReaderComponent,
    DvdlistComponent,
 
  ],
  imports: [RouterModule.forRoot(appRoutes), BrowserModule, AppRoutingModule, FormsModule, CommonModule,HttpClientModule],
  providers: [UserService, AuthguardGuard ],
  
  
  bootstrap: [AppComponent]
})




export class AppModule {}
