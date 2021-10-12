import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error : boolean = false; 

  u = {
    username: "",
    password: ""
  };

  constructor(private adminService: AdminService , private router : Router ) { }

  ngOnInit(): void {
  }

  authenticate() {
    this.adminService.authenticate(this.u).subscribe(
      (      data: any) => {
        console.log(data)
        if (data.idAdmin > 0) {
          sessionStorage.setItem("connectedUser" , data ); 
          console.log("redirection");
          this.router.navigate(['client'])
        }else{
          this.error = true; 
        }
      } ,
      (      error: any) => {
        this.error = true; 
      }
    );
  }


}


