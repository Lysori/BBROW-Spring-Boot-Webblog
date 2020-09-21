package de.awacademy.springbootwebblog.entities;


import javax.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Grades one to 4 stars */
    private byte grade;

    @ManyToOne
    private User author;


    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", grade=" + grade +
                ", author=" + author +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
