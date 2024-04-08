package searchengine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Status status;

    @Column(name = "status_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime statusTime;

    @Column(name = "last_error", columnDefinition = "text default NULL")
    private String lastError;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String url;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Transient
    @OneToMany(mappedBy = "siteId", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Page> sitePages;

    @Transient
    @OneToMany(mappedBy = "siteId", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Lemma> siteLemmas;
}
