import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { LoginComponent } from '../login/login.component';
import { UpdateComponent } from '../update/update.component';
import { ClaimComponent } from '../claim/claim.component';
import { LogoutComponent } from '../logout/logout.component';
import { UpdateMobileComponent } from '../update-mobile/update-mobile.component';
import { UpdateEmailComponent } from '../update-email/update-email.component';
import { UpdateDetailsComponent } from '../update-details/update-details.component';
import { HomeComponent } from '../home/home.component';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'updatedetails',component:UpdateDetailsComponent},
  {path:'update',component:UpdateComponent},
  {path:'mobile',component:UpdateMobileComponent},
  {path:'email',component:UpdateEmailComponent},
  {path:'claim',component:ClaimComponent},
  {path:'logout',component:LogoutComponent},
  {path:'**',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NavigateRoutingModule { }
