import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListComponent } from './list/list.component';
import { UpdateComponent } from './update/update.component';
import { NavigateRoutingModule } from './navigate/navigate-routing.module';
import { HttpErrorInterceptor } from './http-interceptor';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { ListClaimComponent } from './list-claim/list-claim.component';
import { DeleteClaimComponent } from './delete-claim/delete-claim.component';
@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    UpdateComponent,
    LoginComponent,
    LogoutComponent,
    HomeComponent,
    ListClaimComponent,
    DeleteClaimComponent
   
  ],
  imports: [
    BrowserModule, NavigateRoutingModule,
    FormsModule,
    HttpClientModule, NgxPaginationModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
