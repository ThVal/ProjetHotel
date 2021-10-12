import { Component, OnInit, ViewChild } from '@angular/core';
import { Client } from '../classe/client';
import { Hotel } from '../classe/hotel';
import { Reservation } from '../classe/reservation'; 
import { ClientService } from '../service/client.service';
import { HotelService } from '../service/hotel.service';
import { ReservationService } from '../service/reservation.service';


@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  reservation: Reservation = new Reservation();
  reservations : Array<Reservation> = [];
  hotel : Hotel = new Hotel();
  hotels: Array<Hotel> = [];
  client : Client = new Client();
  clients: Array<Client> = [];
  @ViewChild( 'closebutton' ) closebuttonelement: any; 
  success : boolean = false; 
  error : boolean = false; 
  search : String  = "" ; 




  constructor(private reservationService: ReservationService, private hotelService: HotelService, private clientService: ClientService) { }

  ngOnInit(): void {
    this.loadReservation();

    this.hotelService.loadHotel().subscribe(
      data => { 
        this.hotels = data;
      });


    this.clientService.loadClient().subscribe(
      data => { 
          this.clients = data;}    

      );

  }


  loadReservation(): void {
    this.reservationService.loadReservation().subscribe(
      data => {
        console.log(data)
        this.reservations = data;
      }
    )
  }  


  delete( id : number | undefined ): void{
    if( confirm( "Êtes vous sur ?" ) ){
      this.reservationService.deleteReservation( id ).subscribe(
        data => { 
          this.loadReservation();
          this.success = true; 
          }
        );
      }
    }

  edit( id? : number| undefined ): void{
    this.reservationService.getReservation( id ).subscribe(
      data => {
        this.reservation= data;
        console.log(data);
      } , 
      error => {
        console.log( error )
        this.error = true; 
      }
    );
  }


  resetForm(){
    this.error = false;
    this.success = false;
    this.reservation = new Reservation();
  }


  submitForm() : void {

    if( this.reservation.idReservation == undefined ){
      this.reservationService.addReservation( this.reservation ).subscribe(
        data => { 
          console.log( data ); 
          this.closebuttonelement.nativeElement.click();
          this.loadReservation();
          this.success = true; 
        }
      )
    }else{
      // try

      this.reservationService.editReservation( this.reservation ).subscribe(
        data => { 
          //console.log( data ); 
          this.closebuttonelement.nativeElement.click();
          this.loadReservation();
          this.success = true; 
        },
        // catch si la req echoue 
        error => {
          //console.log( error )
          this.error = true; 
        }
        
      )
    }


    console.log( this.reservation );
    
  }





}
