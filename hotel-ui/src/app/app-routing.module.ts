import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthentificationGuard } from './authentification.guard';
import { ClientComponent } from './client/client.component';
import { HotelComponent } from './hotel/hotel.component';
import { LoginComponent } from './login/login.component';
import { ReservationComponent } from './reservation/reservation.component';


const routes: Routes = [
  {path:"client",component:ClientComponent, canActivate:[AuthentificationGuard]},
  {path:"hotel",component:HotelComponent, canActivate:[AuthentificationGuard]},
  {path:"reservation",component:ReservationComponent, canActivate:[AuthentificationGuard]},
  {path:"login", component:LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
