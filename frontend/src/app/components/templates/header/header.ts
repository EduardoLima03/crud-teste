import { Component } from '@angular/core';
import { MatButton, MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
  MatToolbarModule, MatButtonModule],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
  title = 'Crud Teste';

  titledescript() {
    return this.title;
  }
}
