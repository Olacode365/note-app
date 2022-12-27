package africa.semicolon.noteapp.services;

import africa.semicolon.noteapp.dto.request.CreateUserRequest;
import africa.semicolon.noteapp.dto.request.LoginRequest;
import africa.semicolon.noteapp.dto.response.CreateUserResponse;
import africa.semicolon.noteapp.dto.response.LoginResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest createUserRequest);
    LoginResponse login(LoginRequest loginRequest);
}
