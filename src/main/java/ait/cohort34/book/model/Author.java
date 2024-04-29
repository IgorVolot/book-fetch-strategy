package ait.cohort34.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = "fullName")
@Entity
public class Author {
    @Id
    private String fullName;
    @ManyToMany(mappedBy = "authors")
    @Singular
    private Set<Book> books;
}
