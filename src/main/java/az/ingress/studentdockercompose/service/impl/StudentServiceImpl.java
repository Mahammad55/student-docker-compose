package az.ingress.studentdockercompose.service.impl;

import az.ingress.studentdockercompose.dto.request.StudentRequest;
import az.ingress.studentdockercompose.dto.response.StudentResponse;
import az.ingress.studentdockercompose.entity.Student;
import az.ingress.studentdockercompose.enums.EnumAvailableStatus;
import az.ingress.studentdockercompose.mapper.StudentMapper;
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

    StudentMapper studentMapper;

    @Override
    public StudentResponse getStudentById(Long studentId) {
        Student student = studentRepository.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.value);

        return studentMapper.entityToResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAllByActive(EnumAvailableStatus.ACTIVE.value);

        return students.stream()
                .map(studentMapper::entityToResponse)
                .toList();
    }

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = studentMapper.requestToEntity(studentRequest);
        studentRepository.save(student);
        return studentMapper.entityToResponse(student);
    }

    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.value);

        student.setName(studentRequest.getName());
        student.setSurname(studentRequest.getSurname());
        student.setDob(studentRequest.getDob());
        student.setAddress(studentRequest.getAddress());
        studentRepository.save(student);

        return studentMapper.entityToResponse(student);
    }

    @Override
    public StudentResponse deleteStudentById(Long studentId) {
        Student student = studentRepository.findStudentByIdAndActive(studentId, EnumAvailableStatus.ACTIVE.value);
        student.setActive(EnumAvailableStatus.DEACTIVE.value);
        studentRepository.save(student);

        return studentMapper.entityToResponse(student);
    }
}
