package crio.xmeme.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemeConstraintViolationException extends RuntimeException {

    List<String> violations;
    public MemeConstraintViolationException(List<String> violations) {
        this.violations = violations;
    }
}
