package az.ingress.studentdockercompose.mapper;

import az.ingress.studentdockercompose.dto.request.StudentRequest;
import az.ingress.studentdockercompose.dto.response.StudentResponse;
import az.ingress.studentdockercompose.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponse entityToResponse(Student student);

    Student requestToEntity(StudentRequest studentRequest);
}
