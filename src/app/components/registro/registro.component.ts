import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/shared/services/api.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  fieldTextType!: boolean;
  public registro_form!: UntypedFormGroup;

  constructor(private router: Router, private api: ApiService) {}

  ngOnInit(): void {
    this.crearForm();
  }

  crearForm() {
    this.registro_form = new UntypedFormGroup({
      nombre: new UntypedFormControl('', Validators.required),
      apellidos: new UntypedFormControl('', Validators.required),
      nick: new UntypedFormControl('', Validators.required),
      email: new UntypedFormControl('' , [Validators.required, Validators.email]),
      password: new UntypedFormControl('', [Validators.required, Validators.minLength(8)])
    });
  }

  verPassword() {
    this.fieldTextType = !this.fieldTextType;
  }

  get nombre(): any {
    return this.registro_form.get('nombre');
  }

  get apellidos(): any {
    return this.registro_form.get('apellidos');
  }

  get nick(): any {
    return this.registro_form.get('nick');
  }

  get email(): any {
    return this.registro_form.get('email');
  }

  get password(): any {
    return this.registro_form.get('password');
  }

  registrar(): void {
    const formData = this.registro_form.value;

    console.log(formData);

    // this.api.registro(formData.nombre, formData.apellidos, formData.nick, formData.email, formData.password).subscribe(
    //   (registro: any) => {
    //     console.log(registro);
    //   },
    //   (error) => {
    //     console.log(error);
    //   }
    // );

    
    this.router.navigate(['/login']);
  }

}
