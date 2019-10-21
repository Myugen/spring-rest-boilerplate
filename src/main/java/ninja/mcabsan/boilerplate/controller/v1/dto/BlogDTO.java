package ninja.mcabsan.boilerplate.controller.v1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ninja.mcabsan.boilerplate.controller.v1.dto.common.AbstractAuditingAndLogicalDeletedDTO;

@Getter
@Setter
@NoArgsConstructor
public class BlogDTO extends AbstractAuditingAndLogicalDeletedDTO {


    private static final long serialVersionUID = -954504549499011645L;

    private String title;
    private String content;
}
