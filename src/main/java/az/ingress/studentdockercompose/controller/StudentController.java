package az.ingress.studentdockercompose.controller;

import az.ingress.studentdockercompose.dto.request.StudentRequest;
import az.ingress.studentdockercompose.dto.response.StudentResponse;
import az.ingress.studentdockercompose.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id") Long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.saveStudent(studentRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable("id") Long studentId,
                                                         @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(studentId, studentRequest));
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponse> deleteStudent(@PathVariable("id") Long studentId) {
        return ResponseEntity.ok(studentService.deleteStudentById(studentId));
    }
}
