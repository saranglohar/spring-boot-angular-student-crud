import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http: HttpClient) { }

  getAllStudents(): Observable<any> {
    return this.http.get("http://localhost:8080/students");
  }

  createStudent(student: any): Observable<any> {
    return this.http.post("http://localhost:8080/students", student);
  }

  deleteStudent(studentId: any): Observable<any> {
    return this.http.delete("http://localhost:8080/students/" + studentId);
  }
}
