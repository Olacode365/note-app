package africa.semicolon.noteapp.data.repository;

import africa.semicolon.noteapp.data.model.User;

import java.util.List;


public interface UserRepository {
  User save(User user);
  User findById(String id);
  User findByEmail(String email);
  List<User> findByFirstName(String firstName);

  User update(String userId, User newUser);
  void deleteById(String userId);

}
