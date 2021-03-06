import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './modules/home/home.component';
import { DashboardComponent } from './modules/dashboard/dashboard.component';
import {AppointmentsComponent} from "./modules/dashboard/appointments/appointments.component";
import { DepartmentsAndRoomsComponent } from './modules/dashboard/departments-and-rooms/departments-and-rooms.component';
import { DrugsComponent } from './modules/dashboard/drugs/drugs.component';
import { PageNotFoundComponent } from './modules/page-not-found/page-not-found.component';
import {DoctorsComponent} from "./modules/dashboard/doctors/doctors.component";
import {PrescriptionsComponent} from "./modules/dashboard/prescriptions/prescriptions.component";

const routes: Routes = [
    { path: '', component: HomeComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'departments-and-rooms', component: DepartmentsAndRoomsComponent },
  { path: 'drugs', component: DrugsComponent },
  { path: 'doctors', component: DoctorsComponent },
  { path: 'prescriptions', component: PrescriptionsComponent },
    {path: 'appointments', component: AppointmentsComponent},
{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
