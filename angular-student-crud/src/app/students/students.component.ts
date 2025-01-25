import { Component } from '@angular/core';
import { StudentsService } from '../services/students.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.scss',
  imports: [HttpClientModule, CommonModule],
  providers: [StudentsService],
})
export class StudentsComponent {

  studentsList: any[] = [];

  constructor(private studentsService: StudentsService) {
    this.fetchAllStudents();
  }

  fetchAllStudents() {
    this.studentsService.getAllStudents().subscribe((response) => {
      console.log(response);
      this.studentsList = response;
    })
  }


  addStudent() {
    const random = Math.random() * 100000;
    const student = {
      id: random,
      name: "Saaa" + random,
      marks: random + 5,
    }

    this.studentsService.createStudent(student).subscribe((response) => {

      this.fetchAllStudents();
    })
  }

  deleteStudent(studentId: any) {
    this.studentsService.deleteStudent(studentId).subscribe((response) => {

      this.fetchAllStudents();
    })
  }
}
