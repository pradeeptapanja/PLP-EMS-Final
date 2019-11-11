import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponent } from '../search/search.component';
import { AddComponent } from '../add/add.component';
import { DisplayComponent } from '../display/display.component';
import { DeleteComponent } from '../delete/delete.component';
import { UpdateComponent } from '../update/update.component';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { HomeComponent } from '../home/home.component';

const routes: Routes = [
  {path:"",redirectTo:"/home", pathMatch:"full"},
  {path:"home", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"logout", component:LogoutComponent},
  {path:"search", component:SearchComponent},
  {path:"add", component:AddComponent},
  {path:"delete", component:DeleteComponent},
  {path:"display", component:DisplayComponent},
  {path:"update", component:UpdateComponent},
  {path:"**" , redirectTo:"/login", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
