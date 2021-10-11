import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Client } from '../classe/client';
import { httpOptions } from '../variables';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor( private http : HttpClient ) { }
  
  loadClient(): Observable<Client[]> {
  
  /*  let searchCondition = ""

    if( search != undefined && search.length > 0 ){
      searchCondition = "?search="+search; 
    }

    console.log("chargement des clients" + environment.apiUrl  + "clients"+searchCondition );*/
    return this.http.get<Client[]>( environment.apiUrl  + "clients", httpOptions );
  }

  getClient( id? : number ) : Observable<Client> {
    return this.http.get<Client>( environment.apiUrl  + "clients/"+id , httpOptions );
  }

  addClient( client : Client ) : Observable<Client> {
    return this.http.post<Client>( environment.apiUrl + "clients" , client , httpOptions );
  }

  editClient( client : Client ) : Observable<Client> {
    console.log("Objet appelé vers le backend")
    console.log(client);
    return this.http.put<Client>( environment.apiUrl + "clients/"+client.idClient, client , httpOptions )
  }

  deleteClient( id : number | undefined ) : Observable<any> {
    return this.http.delete( environment.apiUrl + "clients/"+id , httpOptions )
  }



}