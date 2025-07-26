import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { HttpService } from '../../services/http-service';
import { HttpClient, provideHttpClient} from '@angular/common/http';

@Component({
  standalone:true,
  selector: 'app-user',
  imports: [CommonModule],
  templateUrl: './user.html',
  styleUrl: './user.css'
})

export class User {
  profiles: any[] = [];

  private httpService = inject(HttpService);

  ngOnInit() {
    this.httpService.get<any[]>('/permission').subscribe(data => {
      this.profiles = data;
      console.log(this.profiles);
    }, error => {
      console.error('Error fetching user data', error);
    });
  }
}
