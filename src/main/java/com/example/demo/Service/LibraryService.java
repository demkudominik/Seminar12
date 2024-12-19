package com.example.demo.Service;

import com.example.demo.Model.Author;
import com.example.demo.Model.Buch;
import com.example.demo.Model.User;
import com.example.demo.Repository.AuthorRepo;
import com.example.demo.Repository.BuchRepo;
import com.example.demo.Repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LibraryService {
    AuthorRepo authorRepo;
    UserRepo userRepo;
    BuchRepo buchRepo;

    public void addUser(String name, String contactData) {
        userRepo.save(new User(name, contactData));
    }

    public void addAuthor(String name) {
        authorRepo.save(new Author(name));
    }

    public void addBuch(String title, String ISBN, Integer authorId, String genre) {
        Author author = authorRepo.getReferenceById(authorId);
        buchRepo.save(new Buch(title, ISBN, genre, author));

    }

    public void deleteAuthor(int authorId) {
        authorRepo.deleteById(authorId);
    }

    public void deleteBuch(int buchId) {
        buchRepo.deleteById(buchId);
    }

    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    public List<Buch> getBuchs() {
        return buchRepo.findAll();
    }

    public void rentBuch(int buchId, int userId) {
        User user = userRepo.getReferenceById(userId);
        Buch buch = buchRepo.getReferenceById(buchId);
        buch.getUsers().add(user);
        buchRepo.save(buch);
    }

    public void returnBuch(int buchId, int userId) {
        Buch buch = buchRepo.getReferenceById(buchId);
        buch.getUsers().removeIf(user -> user.getId() == userId);
        buchRepo.save(buch);
    }
}
