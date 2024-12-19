package com.example.demo.Model;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;

@Entity
@Table(name = "buch", schema = "db" )
@Getter @Setter @ToString @NoArgsConstructor @RequiredArgsConstructor


public class Buch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @NonNull
    @Column(name="Title")
    private String title;
    @NonNull
    @Column(name="ISBN")
    private String isbn;
    @NonNull
    @Column(name="genra")
    private String genra;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "AuthorID")
    private Author author;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "User_Buch",joinColumns = @JoinColumn(name = "UserID"),inverseJoinColumns = @JoinColumn(name = "BuchID"))
    private List<User> users;



}
