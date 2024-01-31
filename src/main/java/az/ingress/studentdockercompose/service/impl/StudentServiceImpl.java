package az.ingress.studentdockercompose.service.impl;

import az.ingress.studentdockercompose.dto.request.StudentRequest;
import az.ingress.studentdockercompose.dto.response.StudentResponse;
import az.ingress.studentdockercompose.entity.Student;
import az.ingress.studentdockercompose.enums.EnumAvailableStatus;
import az.ingress.studentdockercompose.repository.StudentRepository;
import az.ingress.studentdockercompose.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public StudentResponse getStudentById(Long studentId) {
        Student student = studentRepository.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.value);

        return builder(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAllByActive(EnumAvailableStatus.ACTIVE.value);

        return students.stream()
                .map(this::builder)
                .toList();
    }

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = toStudent(studentRequest);
        studentRepository.save(student);
        return builder(student);
    }

    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.value);

        student.setName(studentRequest.getName());
        student.setSurname(studentRequest.getSurname());
        student.setDob(studentRequest.getDob());
        student.setAddress(studentRequest.getAddress());
        studentRepository.save(student);

        return builder(student);
    }

    @Override
    public StudentResponse deleteStudentById(Long studentId) {
        Student student = studentRepository.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.value);
        student.setActive(EnumAvailableStatus.DEACTIVE.value);
        studentRepository.save(student);

        return builder(student);
    }


    private Student toStudent(StudentRequest studentRequest) {
        return Student.builder()
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .address(studentRequest.getAddress())
                .dob(studentRequest.getDob())
                .build();
    }

    private StudentResponse builder(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .dob(student.getDob())
                .address(student.getAddress())
                .build();
    }
}
