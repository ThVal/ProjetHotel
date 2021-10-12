import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Reservation } from '../classe/reservation';
import { httpOptions } from '../variables';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor( private http : HttpClient ) { }
  
  loadReservation(): Observable<Reservation[]> {
  
  /*  let searchCondition = ""

    if( search != undefined && search.length > 0 ){
      searchCondition = "?search="+search; 
    }

    console.log("chargement des hotels" + environment.apiUrl  + "hotels"+searchCondition );*/
    return this.http.get<Reservation[]>( environment.apiUrl  + "reservations", httpOptions );
  }

  getReservation( id? : number ) : Observable<Reservation> {
    return this.http.get<Reservation>( environment.apiUrl  + "reservations/"+id , httpOptions );
  }

  addReservation( reservation : Reservation ) : Observable<Reservation> {
    return this.http.post<Reservation>( environment.apiUrl + "reservations" , reservation , httpOptions );
  }

  editReservation( reservation : Reservation) : Observable<Reservation> {
    console.log("Objet appelé vers le backend")
    console.log(reservation);
    return this.http.put<Reservation>( environment.apiUrl + "reservations/"+reservation.idReservation, reservation, httpOptions )
  }

  deleteReservation( id : number | undefined ) : Observable<any> {
    return this.http.delete( environment.apiUrl + "reservations/"+id , httpOptions )
  }
}
