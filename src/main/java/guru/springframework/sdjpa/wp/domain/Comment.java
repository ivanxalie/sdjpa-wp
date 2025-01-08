package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * +----------------------+-----------------+------+-----+-------------------+-------------------+
 * | Field                | Type            | Null | Key | Default           | Extra             |
 * +----------------------+-----------------+------+-----+-------------------+-------------------+
 * | user_id              | bigint unsigned | NO   |     | 0                 |                   |
 * +----------------------+-----------------+------+-----+-------------------+-------------------+
 */

@Getter
@Setter
@Entity
@Table(name = "wp_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_post_id", nullable = false)
    @NotNull
    private Long postId;

    @Column(name = "comment_author", nullable = false)
    @Size(max = 255)
    @NotBlank
    private String author;

    @Column(name = "comment_author_email", nullable = false)
    @Size(max = 100)
    @NotBlank
    @Email
    private String authorEmail;

    @Column(name = "comment_author_url", nullable = false)
    @Size(max = 200)
    @NotBlank
    @URL
    private String authorUrl;

    @Column(name = "comment_author_ip", nullable = false)
    @Size(max = 100)
    @NotBlank
    private String authorIp;

    @Column(name = "comment_date", nullable = false)
    @NotNull
    @PastOrPresent
    private Timestamp date;

    @Column(name = "comment_date_gmt", nullable = false)
    @NotNull
    @PastOrPresent
    private Timestamp dateGmt;

    @Column(name = "comment_content", nullable = false, columnDefinition = "TEXT")
    @NotBlank
    @Lob
    private String content;

    @Column(name = "comment_karma", nullable = false)
    @NotNull
    private Integer karma;

    @Column(name = "comment_approved", nullable = false)
    @NotBlank
    @Size(max = 20)
    private String approved;

    @Column(name = "comment_agent", nullable = false)
    @NotBlank
    @Size(max = 255)
    private String agent;

    @Column(name = "comment_type", nullable = false)
    @NotBlank
    @Size(max = 20)
    private String type;

    @OneToMany
    @JoinColumn(name = "comment_parent")
    private Set<Comment> children = new HashSet<>();

    @OneToMany(mappedBy = "comment")
    private Set<CommentMeta> commentMetas = new HashSet<>();

    @ManyToOne
    private User user;
}
