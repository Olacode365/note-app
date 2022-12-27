package africa.semicolon.noteapp.services;

import africa.semicolon.noteapp.data.model.User;
import africa.semicolon.noteapp.data.repository.UserRepository;
import africa.semicolon.noteapp.dto.request.CreateUserRequest;
import africa.semicolon.noteapp.dto.request.LoginRequest;
import africa.semicolon.noteapp.dto.response.CreateUserResponse;
import africa.semicolon.noteapp.dto.response.LoginResponse;
import africa.semicolon.noteapp.exceptions.NoteAppException;


public class UserServiceImpl implements UserService{
    private static int counter;
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest){
        User user = userRepository.findByEmail(createUserRequest.getEmail());
        if(user != null){
            throw new NoteAppException("User with email already exist!");
        }
        user = new User(createUserRequest.getFirstName(),
                createUserRequest.getLastName(), createUserRequest.getEmail(), createUserRequest.getPassword());
        user.setId(String.valueOf(counter+=1));
        User savedUser = userRepository.save(user);
        return new CreateUserResponse("User with Id "+savedUser.getId()+" has been successfully saved");
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if(user == null){
            throw new NoteAppException("Wrong email or password!");
        }
        if(user.getPassword().equals(loginRequest.getPassword())){
            return new LoginResponse("You have successfully logged in!");
        }
        throw new NoteAppException("Wrong email or password!");
    }
}
