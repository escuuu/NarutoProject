import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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
      email: new UntypedFormControl('', Validators.required),
      password: new UntypedFormControl('', Validators.required)
    });
  }

  login = () => {
    var email = this.login_form.value.email;
    var password = this.login_form.value.password;

    this.api.login(email, password).subscribe(
      (logueo: any) => {
        console.log(logueo);
      },
      () => {
        alert('La BBDD no funciona');
      }
    );

    // const token = '1234';
    // localStorage.setItem('token', token);

    // this.router.navigate(['/wiki']);
  }
}
