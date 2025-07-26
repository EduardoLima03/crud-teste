import { Component, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/templates/header/header';
import { Footer } from './components/templates/footer/footer';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatButtonModule, 
    MatToolbarModule, MatCardModule, HttpClientModule, Header, Footer],
  templateUrl: 'app.componet.html',
})
export class App {
  protected readonly title = signal('frontend');
}
