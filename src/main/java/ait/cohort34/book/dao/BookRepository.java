package ait.cohort34.book.dao;

import ait.cohort34.book.model.Author;
import ait.cohort34.book.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public class BookRepository {

    @PersistenceContext // (type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Transactional
    public void addBooks() {
        Author markTwain = Author.builder()
                .fullName("Mark Twain")
                .build();
        em.persist(markTwain);
        Book pandp = Book.builder()
                .isbn("978-3-16-148410-0")
                .author(markTwain)
                .title("The Prince and the Pauper")
                .build();
        em.persist(pandp);

        Author ilf = Author.builder()
                .fullName("Ilya Ilf")
                .build();
        Author petrov = Author.builder()
                .fullName("Yevgeny Petrov")
                .build();
        em.persist(ilf);
        em.persist(petrov);
        Book chairs12 = Book.builder()
                .isbn("978-3-16-148410-1")
                .author(ilf)
                .author(petrov)
                .title("The Twelve Chairs")
                .build();
        em.persist(chairs12);
    }

    // @Transactional(readOnly = true)
    public void printAuthorsOfBook(String isbn) {
//        Book book = em.find(Book.class, isbn);
        TypedQuery<Book> query = em.createQuery("select b from Book b left join fetch b.authors a where b.isbn=?1", Book.class);
        query.setParameter(1, isbn);
        Book book = query.getSingleResult();
        Set<Author> authors = book.getAuthors();
        authors.forEach(author -> System.out.println(author.getFullName()));
        // Do something...
    }
}
