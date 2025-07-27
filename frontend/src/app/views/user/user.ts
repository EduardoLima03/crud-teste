import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { HttpService } from '../../services/http-service';
import { MatTableModule } from '@angular/material/table';
import { MatChipsModule } from '@angular/material/chips';
import { MatBadgeModule } from '@angular/material/badge';
import { ChangeDetectorRef } from '@angular/core';
import { MatChipListbox } from '@angular/material/chips';

@Component({
  standalone:true,
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


  ngOnInit() {
    this.httpService.get<any[]>('/users').subscribe(data => {
      this.users = data;
      this.cdr.detectChanges();
      console.log(this.users);
    }, error => {
      console.error('Error fetching user data', error);
    });
  }
}
