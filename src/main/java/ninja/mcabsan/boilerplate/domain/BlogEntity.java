package ninja.mcabsan.boilerplate.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ninja.mcabsan.boilerplate.domain.common.AbstractAuditingAndLogicalDeletedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_blogs")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BlogEntity extends AbstractAuditingAndLogicalDeletedEntity {

    private static final long serialVersionUID = 4450314587903076095L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_blogs_id")
    @SequenceGenerator(name = "seq_tb_blogs_id", sequenceName = "seq_tb_blogs_id", allocationSize = 1, initialValue = 10)
    private Long id;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank
    @Column(name = "content", length = 255)
    private String content;

}
