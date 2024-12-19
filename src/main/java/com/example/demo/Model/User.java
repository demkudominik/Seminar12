package com.example.demo.Model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="User",schema = "db")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    int id;
    @NonNull
    @Column(name= "name")
    String name;
    @NonNull
    @Column(name="ContactData")
    String contactData;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "users")
    List<User> users;
}
