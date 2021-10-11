export class Hotel {

        //comme Java 
        idHotel: number | undefined;
        nom: string| undefined;
        nbEtoile: number | undefined
        ville : string| undefined;
        telephoneHotel: string | undefined;
        emailHotel:string | undefined;
        
        
    
        constructor(_id?: number | undefined, _nom?: string | undefined,_nbEtoile?: number | undefined,_ville?: string | undefined, _tel?: string | undefined, _email?: string | undefined) {
            this.idHotel = _id;
            this.nom = _nom;
            this.nbEtoile = _nbEtoile;
            this.ville = _ville
            this.telephoneHotel = _tel;
            this.emailHotel = _email;
            

    
        }
    
    }
