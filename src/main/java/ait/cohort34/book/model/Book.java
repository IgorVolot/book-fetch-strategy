package ait.cohort34.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = "isbn")
@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    @Singular
    @ManyToMany // (fetch = FetchType.EAGER)
    private Set<Author> authors;
}
