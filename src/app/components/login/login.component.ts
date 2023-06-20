import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/shared/classes/user';
import { ApiService } from 'src/app/shared/services/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public login_form!: UntypedFormGroup;

  constructor(private api: ApiService, private router: Router) {}

  ngOnInit(): void {
    this.CrearForm();
  }

  private CrearForm(): void {
    this.login_form = new UntypedFormGroup({
      gmail: new UntypedFormControl('', Validators.required),
      password: new UntypedFormControl('', Validators.required)
    });
  }

  login = () => {
    var gmail = this.login_form.value.gmail;
    var password = this.login_form.value.password;

    this.api.login(gmail, password).subscribe(
      (logueo: User) => {
        console.log(logueo);
        const token = password+gmail;
        localStorage.setItem('token', token);
        localStorage.setItem('user', JSON.stringify(logueo));
        this.router.navigate(['/wiki']);
      },
      (error) => {
        alert(error.error.message);
      }
    );

  }
}
