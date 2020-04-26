package book;

import book.model.Book;
import com.google.inject.persist.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

public class BookDao extends jpa.GenericJpaDao<Book> {

    @Transactional
    Optional<Book> findByIsbn13(String isbn13){
        try {
            return Optional.of(entityManager.createQuery("SELECT b FROM Book b WHERE b.isbn13 = :isbn13", Book.class)
                    .setParameter("isbn13", isbn13)
                    .getSingleResult());
        }catch (NoResultException e) {
            return Optional.empty();
        }
    }

}