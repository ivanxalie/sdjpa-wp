package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Entity
@Table(name = "wp_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_pass")
    private String password;

    @Column(name = "user_nicename")
    private String nicename;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_url")
    private String url;

    @Column(name = "user_registered")
    private Timestamp registered;

    @Column(name = "user_activation_key")
    private String activationKey;

    @Column(name = "user_status")
    private Integer status;

    @Basic(optional = false)
    private String displayName;
}
