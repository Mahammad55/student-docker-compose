package az.ingress.studentdockercompose.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    Long id;

    String name;

    String surname;

    String address;

    Date dob;
}
