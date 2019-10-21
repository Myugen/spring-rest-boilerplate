package ninja.mcabsan.boilerplate.domain.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractAuditingAndLogicalDeletedEntity extends AbstractAuditingEntity {

    private static final long serialVersionUID = 6581481637976553408L;

    private Instant deletedDate;
    private String deletedBy;

    public boolean isDeleted() {
        return deletedDate != null;
    }
}
