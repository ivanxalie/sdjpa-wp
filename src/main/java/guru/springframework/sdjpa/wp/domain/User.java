package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "wp_users", indexes = {
        @Index(name = "user_login_key", columnList = "user_login"),
        @Index(name = "user_nicename", columnList = "user_nicename"),
        @Index(name = "user_email", columnList = "user_email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login", length = 60)
    @Size(max = 60)
    @NotBlank
    private String login;

    @Column(name = "user_pass")
    @Size(max = 255)
    @NotBlank
    private String password;

    @Column(name = "user_nicename", length = 50)
    @Size(max = 50)
    @NotBlank
    private String nicename;

    @Column(name = "user_email", length = 100)
    @Email
    @Size(max = 100)
    @NotBlank
    private String email;

    @Column(name = "user_url", length = 100)
    @URL
    @Size(max = 100)
    @NotBlank
    private String url;

    @Column(name = "user_registered")
    @PastOrPresent
    @NotNull
    private Timestamp registered;

    @Column(name = "user_activation_key")
    @Size(max = 255)
    @NotBlank
    private String activationKey;

    @Column(name = "user_status")
    @NotNull
    private Integer status;

    @Column(nullable = false, length = 250)
    @Size(max = 250)
    @NotBlank
    private String displayName;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserMeta> userMetas = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Comment> comments = new HashSet<>();
}
