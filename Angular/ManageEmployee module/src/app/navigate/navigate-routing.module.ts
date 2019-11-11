import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListComponent } from '../list/list.component';
import { UpdateComponent } from '../update/update.component';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { HomeComponent } from '../home/home.component';
import { ListClaimComponent } from '../list-claim/list-claim.component';
import { DeleteClaimComponent } from '../delete-claim/delete-claim.component';

const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:"home", component: HomeComponent},
  {path:'list',component:ListComponent},
  {path:'update',component:UpdateComponent},
  {path:'login',component:LoginComponent},
  {path:'listClaim',component:ListClaimComponent},
  {path:'deleteClaim',component:DeleteClaimComponent},
  {path:'logout',component:LogoutComponent},
  {path:'**',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NavigateRoutingModule { }
