package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "wp_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login")
    @Size(max = 60)
    @NotBlank
    private String login;

    @Column(name = "user_pass")
    @Size(max = 255)
    @NotBlank
    private String password;

    @Column(name = "user_nicename")
    @Size(max = 50)
    @NotBlank
    private String nicename;

    @Column(name = "user_email")
    @Email
    @Size(max = 100)
    @NotBlank
    private String email;

    @Column(name = "user_url")
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

    @Basic(optional = false)
    @Size(max = 250)
    @NotBlank
    private String displayName;
}
