package az.ingress.studentdockercompose.service;

import az.ingress.studentdockercompose.dto.request.StudentRequest;
import az.ingress.studentdockercompose.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse getStudentById(Long studentId);

    List<StudentResponse> getAllStudents();

    StudentResponse saveStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(Long studentId, StudentRequest studentRequest);

    StudentResponse deleteStudentById(Long studentId);
}
