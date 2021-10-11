export class Client {
      //comme Java 
      idClient: number | undefined;
      nomCompletClient: string| undefined;
      telephoneClient: string | undefined
      emailClient : string| undefined;
      adresseClient : string | undefined;
      
      
  
      constructor(_id?: number | undefined, _nom?: string | undefined, _tel?: string | undefined, _email?: string | undefined, _adresse?: string | undefined) {
          this.idClient = _id;
          this.nomCompletClient = _nom;
          this.telephoneClient = _tel;
          this.emailClient = _email;
          this.adresseClient = _adresse;

    
      }
  
  }
