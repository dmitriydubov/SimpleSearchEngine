package searchengine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"index\"")
public class SearchIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page pageId;

    @ManyToOne
    @JoinColumn(name = "lemma_id", nullable = false)
    private Lemma lemmaId;

    @Column(name = "\"rank\"",nullable = false)
    private Float rank;
}
