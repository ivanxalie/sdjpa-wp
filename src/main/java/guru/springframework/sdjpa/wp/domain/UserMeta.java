package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "wp_usermeta")
public class UserMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "umeta_id")
    private Long id;

    private Long userId;

    @Size(max = 255)
    @Column(columnDefinition = "longtext")
    private String metaKey;

    @Lob
    private String metaValue;
}
