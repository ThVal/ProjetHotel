import { HttpHeaders } from "@angular/common/http";
import { environment } from "src/environments/environment";

export const httpOptions = {
    headers : new HttpHeaders({
      'Authorization' : "Basic YWRtaW46YWRtaW4="// admin   - 1234 
    })
  }; 