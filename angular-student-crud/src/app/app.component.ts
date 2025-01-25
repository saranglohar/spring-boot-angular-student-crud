import { Component } from '@angular/core';
import { StudentsComponent } from './students/students.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  imports:[StudentsComponent]
})
export class AppComponent {
  title = 'angular-student-crud';



}
