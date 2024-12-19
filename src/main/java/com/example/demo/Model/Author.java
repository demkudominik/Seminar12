package com.example.demo.Model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

import java.awt.print.Book;

@Entity
@Table(name="User",schema = "db")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    int id;
    @NonNull
    @Column(name="name")
    String name;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "author")
    private List<Buch> buchs;
}
