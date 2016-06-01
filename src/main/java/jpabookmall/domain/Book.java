package jpabookmall.domain;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Long price;
//    @Column(name = "description", nullable = false)
    private String description;

    @Transient
    private String test;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Book{" +
            "no=" + no +
            ", title='" + title + '\'' +
            ", price=" + price +
            ", description='" + description + '\'' +
            ", test='" + test + '\'' +
            '}';
    }
}
