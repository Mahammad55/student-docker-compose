package az.ingress.studentdockercompose.enums;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PUBLIC)
public enum EnumAvailableStatus {
    ACTIVE(1),
    DEACTIVE(0);

    Integer value;
}
