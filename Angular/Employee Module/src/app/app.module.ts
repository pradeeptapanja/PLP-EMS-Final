import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';
import { PasswordComponent } from './password/password.component';
import { BankdetailsComponent } from './bankdetails/bankdetails.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavigateRoutingModule } from './navigate/navigate-routing.module';
import { LoginComponent } from './login/login.component';
import { PasswordStrengthBarModule } from 'ng2-password-strength-bar';
import { HttpErrorInterceptor } from './http-interceptor';
import { NgxPaginationModule } from 'ngx-pagination';
import { LogoutComponent } from './logout/logout.component';
import { UpdateComponent } from './update/update.component';
import { ListComponent } from './list/list.component';
import { HomeComponent } from './home/home.component';
import { ApplyClaimComponent } from './apply-claim/apply-claim.component';
import { ModifyClaimComponent } from './modify-claim/modify-claim.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    SearchComponent,
    PasswordComponent,
    BankdetailsComponent,
    LoginComponent,
    LogoutComponent,
    UpdateComponent,
    ListComponent,
    HomeComponent,
    ApplyClaimComponent,
    ModifyClaimComponent,
  
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NavigateRoutingModule,
    PasswordStrengthBarModule,
    NgxPaginationModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
