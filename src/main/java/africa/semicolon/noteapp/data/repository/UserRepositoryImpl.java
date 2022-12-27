package africa.semicolon.noteapp.data.repository;

import africa.semicolon.noteapp.data.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    private Map<String, User> database = new HashMap<>();

    @Override
    public User save(User user) {
        return database.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return database.get(id);
    }

    @Override
    public User findByEmail(String email) {
        for(Map.Entry<String, User> userEntry : database.entrySet()){
            String userId = userEntry.getKey();
            User user = userEntry.getValue();
            if(user.getEmail().equals(email)){
                return user;

            }
        }
        return null;
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        List<User> users = new ArrayList<>();
        for(Map.Entry<String, User> userEntry : database.entrySet()){
            String userId = userEntry.getKey();
            User user = userEntry.getValue();
            if(user.getFirstName().equals(firstName)){
               users.add(user);

            }
        }
        return users;
    }

    @Override
    public User update(String userId, User newUser) {
        return database.replace(userId, newUser);
    }

    @Override
    public void deleteById(String userId) {
       database.remove(userId);
    }
}
