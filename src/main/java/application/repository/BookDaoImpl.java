package application.repository;

import application.model.Book;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    public BookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            try {
                transaction = session.beginTransaction();
                session.save(book);
                transaction.commit();
                return book;
            } catch (Exception exception) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw new RuntimeException("Can't save book: " + book, exception);
            }
        }
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> sessionQuery = session.createQuery("from Book", Book.class);
            return sessionQuery.getResultList();
        }
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Book.class, id));
        }
    }
}
