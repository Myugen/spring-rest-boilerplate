package ninja.mcabsan.boilerplate.controller.v1.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public abstract class AbstractAuditingDTO implements Serializable {
    private static final long serialVersionUID = 3098705449416541191L;

    private Long id;
    private Instant createdDate;
    private String createdBy;
    private Instant modifiedDate;
    private String modifiedBy;
}
