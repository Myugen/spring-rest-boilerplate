package ninja.mcabsan.boilerplate.controller.v1.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class AbstractAuditingAndLogicalDeletedDTO extends AbstractAuditingDTO {
    private static final long serialVersionUID = -2044919241381949184L;

    private Instant deletedDate;
    private String deletedBy;
}
