import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { SearchComponent } from '../search/search.component';
import { PasswordComponent } from '../password/password.component';
import { BankdetailsComponent } from '../bankdetails/bankdetails.component';
import { LoginComponent } from '../login/login.component';
import { LogoutComponent } from '../logout/logout.component';
import { UpdateComponent } from '../update/update.component';
import { ListComponent } from '../list/list.component';
import { HomeComponent } from '../home/home.component';
import { ApplyClaimComponent } from '../apply-claim/apply-claim.component';
import { ModifyClaimComponent } from '../modify-claim/modify-claim.component';

const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'list',component:ListComponent},
  {path:'search',component:SearchComponent},
  {path:'password',component:PasswordComponent},
  {path:'bank',component:BankdetailsComponent},
  {path:'update',component:UpdateComponent},
  {path:'applyClaim',component:ApplyClaimComponent},
  {path:'modifyClaim',component:ModifyClaimComponent},
  {path:'logout',component:LogoutComponent},
 // {path:'login', component : LoginComponent},
  {path:'**',redirectTo:'/register',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NavigateRoutingModule { }
