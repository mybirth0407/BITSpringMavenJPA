package jpabookmall;

import jpabookmall.domain.Book;

import javax.persistence.*;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpabookmall");

        EntityManager entityManager =
            entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();

        tx.begin();

        try {
//            insertLogic(entityManager);
//            insertAndUpdateLogic(entityManager);
            fineOneLogic(entityManager);
        }
        catch (Exception e) {
            tx.rollback();
        }

        tx.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void insertLogic(EntityManager entityManager) {
        Book book = new Book();
        book.setNo(1L);
        book.setTitle("자바의 신");
        book.setPrice(200L);

        entityManager.persist(book);
    }

    public static void insertAndUpdateLogic(EntityManager entityManager) {
        Book book = new Book();
        book.setNo(2L);
        book.setTitle("자바의 정석");
        book.setPrice(30000L);

        entityManager.persist(book);

        book.setPrice(0L);
    }

    public static void fineOneLogic(EntityManager entityManager) {
        Book book = entityManager.find(Book.class, 1L);
        System.out.println(book);

        book.setTitle("가나다라");
    }

    public static void findListLogic(EntityManager entityManager) {
        TypedQuery<Book> query = entityManager.createQuery(
            "select m from Book m", Book.class);
        List<Book> list = query.getResultList();

        for (Book book: list) {
            System.out.println(book);
        }
    }

    public static void findAndRemoveLogic(EntityManager entityManager) {
        Book book = entityManager.find(Book.class, 1L);
        entityManager.remove(book);
    }



}
