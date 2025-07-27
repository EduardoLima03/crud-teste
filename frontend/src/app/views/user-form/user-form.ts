import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject, Input, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatOptionModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { HttpService } from '../../services/http-service';
import { Router } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-user-form',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatOptionModule,
    MatButtonModule,
    MatCardModule,],
  templateUrl: './user-form.html',
  styleUrl: './user-form.css'
})
export class UserForm implements OnInit {
  @Input() user: any = null;
  isEditMode: boolean = false;
  form!: FormGroup;

  private httpService = inject(HttpService);
  
  constructor(private fb: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.form = this.fb.group({
      idUsers: [null],
      name: ['', Validators.required],
      surname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      active: [1, Validators.required],
      permissionIds: [[], Validators.required]
    });

    if (this.user) {
      this.isEditMode = true;
      this.form.patchValue(this.user);
      this.form.get('password')?.clearValidators();
    }


  }
  
  onSubmit() {
    if (this.form.invalid) return;

    const userData = this.form.value;

    if (this.isEditMode) {
      this.httpService.put(`/users/${userData.idUsers}`, userData).subscribe({
        next: () => {alert('Usuário atualizado com sucesso!');
          this.router.navigate(['/users']);
        },
        error: err => console.error('Erro ao atualizar:', err)
      });
    } else {
      console.log('Cadastrando usuário:', userData);
      this.httpService.post('/users', userData).subscribe({
        next: () => {
          alert('Usuário cadastrado com sucesso!');
          this.router.navigate(['/users']);
          // Reset the form after successful submission
          this.form.reset();
          
        },
        error: err => console.error('Erro ao cadastrar:', err)
      });
    }
  }

}
