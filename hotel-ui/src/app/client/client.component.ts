import { Component, OnInit, ViewChild } from '@angular/core';
import { Client } from '../classe/client'; 
import { HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ClientService } from '../service/client.service';



@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {


  client : Client = new Client();
  clients : Array<Client> = []; 
  @ViewChild( 'closebutton' ) closebuttonelement: any; 
  success : boolean = false; 
  error : boolean = false; 
  search : String  = "" ; 



  constructor(private clientService : ClientService) { } 

  ngOnInit(): void {
    this.loadClient();

      }
  
  loadClient() : void {
    this.clientService.loadClient().subscribe(
      data => { 
        console.log(data)
        this.clients = data; 
      }
    );
      }


  delete( id : number | undefined ): void{
    if( confirm( "Êtes vous sur ?" ) ){
      this.clientService.deleteClient( id ).subscribe(
        data => { 
          this.loadClient();
          this.success = true; 
          }
        );
      }
    }

  edit( id? : number ): void{
    this.clientService.getClient( id ).subscribe(
      data => {
        this.client = data;
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
    this.client = new Client();
  }


  submitForm() : void {

    if( this.client.idClient == undefined ){
      this.clientService.addClient( this.client ).subscribe(
        data => { 
          console.log( data ); 
          this.closebuttonelement.nativeElement.click();
          this.loadClient();
          this.success = true; 
        }
      )
    }else{
      // try

      this.clientService.editClient( this.client ).subscribe(
        data => { 
          //console.log( data ); 
          this.closebuttonelement.nativeElement.click();
          this.loadClient();
          this.success = true; 
        },
        // catch si la req echoue 
        error => {
          //console.log( error )
          this.error = true; 
        }
        
      )
    }


    console.log( this.client );
    
  }

  }



