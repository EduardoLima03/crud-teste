import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { HttpService } from '../../services/http-service';
import { MatTableModule } from '@angular/material/table';
import { MatChipsModule } from '@angular/material/chips';
import { MatBadgeModule } from '@angular/material/badge';
import { ChangeDetectorRef } from '@angular/core';
import { MatChipListbox } from '@angular/material/chips';
import { Router } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-user',
  imports: [CommonModule, MatTableModule, MatChipsModule, MatBadgeModule, MatChipListbox],
  templateUrl: './user.html',
  styleUrl: './user.css'
})

export class User {
  profiles: any[] = [];
  users: any[] = [];
  displayedColumns: string[] = ['name', 'surname', 'email', 'active', 'permissions', 'creationData'];

  private httpService = inject(HttpService);

  private cdr = inject(ChangeDetectorRef); // <- injeta ChangeDetectorRef
  

  constructor(private router: Router) {}

  ngOnInit() {
    this.httpService.get<any[]>('/users').subscribe(data => {
      this.users = data;
      this.cdr.detectChanges();
      console.log(this.users);
    }, error => {
      console.error('Error fetching user data', error);
    });
  }

  // Método para selecionar um usuário ao clicar na linha
  selectedUserId: number | null = null;

  onRowClick(user: any) {
    this.selectedUserId = user.idUsers;
    console.log('Selecionado ID:', this.selectedUserId);
    
  }

  // Método para adicionar deletar usuário
  deleteUser(id: number) {
    if (!confirm('Tem certeza que deseja excluir este usuário?')) return;

    this.httpService.delete(`/users/${id}`).subscribe({
      next: () => {
        // Após exclusão, atualize a lista de usuários
        this.users = this.users.filter(u => u.idUsers !== id);
        this.selectedUserId = null;
      },
      error: () => console.error('Erro ao deletar:', id)
    });
  }

  editUser() {
    const user = this.users.find(u => u.idUsers === this.selectedUserId);
    if (user) {
      this.router.navigate(['/users/form'], { state: { user } });
    }
  }

  createdUser() {
    this.router.navigate(['/users/form']);
  }
}
