import { Component } from '@angular/core';
import { MatButton, MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterModule } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-header',
  imports: [RouterModule,MatToolbarModule, MatButtonModule],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
  title = 'Crud Teste';

  titledescript() {
    return this.title;
  }
}
