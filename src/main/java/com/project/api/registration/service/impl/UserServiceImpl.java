//package com.project.api.registration.service.impl;
//
//import com.project.api.model.User;
//import com.project.api.registration.PasswordResetToken;
//import com.project.api.registration.UserAlreadyExistException;
//import com.project.api.registration.UserDto;
//import com.project.api.registration.VerificationToken;
//import com.project.api.registration.repository.PasswordResetTokenRepository;
//import com.project.api.registration.repository.RoleRepository;
//import com.project.api.registration.repository.UserRepository;
//import com.project.api.registration.repository.VerificationTokenRepository;
//import com.project.api.registration.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.UUID;
//
//@Service("userService")
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private VerificationTokenRepository tokenRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private PasswordResetTokenRepository passwordTokenRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public User findByEmail(String email) {
//        User user = null;
//        user = userRepository.findByEmail(email);
//        return user;
//    }
//
//    @Override
//    public User registerNewUserAccount(final UserDto accountDto) throws UserAlreadyExistException {
//        final User user = new User();
//
//        user.setFirstName(accountDto.getFirstName());
//        user.setLastName(accountDto.getLastName());
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//        user.setEmail(accountDto.getEmail());
//        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User getUser(String verificationToken) {
//        User user = tokenRepository.findByToken(verificationToken).getUser();
//        return user;
//    }
//
//    @Override
//    public void saveRegisteredUser(User user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    public void createVerificationToken(User user, String token) {
//        VerificationToken myToken = new VerificationToken(token, user);
//        tokenRepository.save(myToken);
//    }
//
//    @Override
//    public VerificationToken getVerificationToken(String VerificationToken) {
//        return tokenRepository.findByToken(VerificationToken);
//    }
//
//    @Override
//    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
//        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
//        vToken.updateToken(UUID.randomUUID()
//                .toString());
//        vToken = tokenRepository.save(vToken);
//        return vToken;
//    }
//
//    @Override
//    public void createPasswordResetTokenForUser(User user, String token) {
//        PasswordResetToken myToken = new PasswordResetToken(token, user);
//        passwordTokenRepository.save(myToken);
//    }
//
//    @Override
//    public void changeUserPassword(User user, String password) {
//        user.setPassword(passwordEncoder.encode(password));
//        userRepository.save(user);
//    }
//
//    @Override
//    public User getUserByPasswordResetToken(final String token) {
//        return passwordTokenRepository.findByToken(token)
//                .getUser();
//    }
//
//    @Override
//    public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
//        return passwordEncoder.matches(oldPassword, user.getPassword());
//    }
//
//}
