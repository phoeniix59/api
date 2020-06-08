//package com.project.api.registration.service;
//
//import com.project.api.model.User;
//import com.project.api.registration.UserAlreadyExistException;
//import com.project.api.registration.UserDto;
//import com.project.api.registration.VerificationToken;
//
//public interface UserService {
//
//    User findByEmail(String usernameOrEmail);
//
//    User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;
//
//    User getUser(String verificationToken);
//
//    void saveRegisteredUser(User user);
//
//    void createVerificationToken(User user, String token);
//
//    VerificationToken getVerificationToken(String VerificationToken);
//
//    VerificationToken generateNewVerificationToken(String token);
//
//    void createPasswordResetTokenForUser(User user, String token);
//
//    void changeUserPassword(User user, String password);
//
//    User getUserByPasswordResetToken(String token);
//
//    boolean checkIfValidOldPassword(User user, String oldPassword);
//}
