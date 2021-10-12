import { Client } from "./client"
import { Hotel } from "./hotel"

export class Reservation {


            //comme Java 
            idReservation : number | undefined
            client: Client | undefined;
            hotel: Hotel| undefined;
            dateDebut: Date | undefined
            dateFin : Date| undefined;
            numChambre: number| undefined;
            
            
            
        
            constructor(_id?:number | undefined, _clientId?: Client  | undefined, _hotelId?: Hotel | undefined,_datedeb?: Date | undefined,_datefin?: Date | undefined, _numbChambre?: number| undefined){
                this.idReservation = _id;
                this.client = _clientId;
                this.hotel= _hotelId;
                this.dateDebut = _datedeb;
                this.dateFin = _datefin
                this.numChambre = _numbChambre
               
                
            }

}
