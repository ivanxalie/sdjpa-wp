package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "wp_commentmeta")
public class CommentMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Size(max = 255)
    @Column(columnDefinition = "longtext")
    private String metaKey;

    @Lob
    private String metaValue;
}
