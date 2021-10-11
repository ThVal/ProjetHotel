
import { Component, OnInit, ViewChild } from '@angular/core';
import { Hotel } from '../classe/hotel'; 
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { HotelService } from '../service/hotel.service';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {

  
  hotel : Hotel = new Hotel();
  hotels : Array<Hotel> = []; 
  @ViewChild( 'closebutton' ) closebuttonelement: any; 
  success : boolean = false; 
  error : boolean = false; 
  search : String  = "" ; 



  constructor(private hotelService : HotelService) { } 

  ngOnInit(): void {
    this.loadHotel();

      }
  
  loadHotel() : void {
    this.hotelService.loadHotel().subscribe(
      data => { 
        console.log(data)
        this.hotels = data; 
      }
    );
      }


  delete( id : number | undefined ): void{
    if( confirm( "Êtes vous sur ?" ) ){
      this.hotelService.deleteHotel( id ).subscribe(
        data => { 
          this.loadHotel();
          this.success = true; 
          }
        );
      }
    }

  edit( id? : number ): void{
    this.hotelService.getHotel( id ).subscribe(
      data => {
        this.hotel= data;
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
    this.hotel = new Hotel();
  }


  submitForm() : void {

    if( this.hotel.idHotel == undefined ){
      this.hotelService.addHotel( this.hotel ).subscribe(
        data => { 
          console.log( data ); 
          this.closebuttonelement.nativeElement.click();
          this.loadHotel();
          this.success = true; 
        }
      )
    }else{
      // try

      this.hotelService.editHotel( this.hotel ).subscribe(
        data => { 
          //console.log( data ); 
          this.closebuttonelement.nativeElement.click();
          this.loadHotel();
          this.success = true; 
        },
        // catch si la req echoue 
        error => {
          //console.log( error )
          this.error = true; 
        }
        
      )
    }


    console.log( this.hotel );
    
  }
}
