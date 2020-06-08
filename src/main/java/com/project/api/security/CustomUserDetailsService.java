//package com.project.api.security;
//
//import com.project.api.registration.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service("customUserDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        boolean enabled = true;
//        boolean accountNonExpired = true;
//        boolean credentialsNonExpired = true;
//        boolean accountNonLocked = true;
//
//        if (email.trim().isEmpty()) {
//            throw new UsernameNotFoundException("username is empty");
//        }
//        try {
//            User user = userService.findByEmail(email);
//
//            if (user == null) {
//                throw new UsernameNotFoundException("User " + email + " not found");
//            }
//
//            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // UTIL
//
//    private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
//        return getGrantedAuthorities(getPrivileges(roles));
//    }
//
//    private final List<String> getPrivileges(final Collection<Role> roles) {
//        final List<String> privileges = new ArrayList<String>();
//        final List<Privilege> collection = new ArrayList<Privilege>();
//        for (final Role role : roles) {
//            collection.addAll(role.getPrivileges());
//        }
//        for (final Privilege item : collection) {
//            privileges.add(item.getName());
//        }
//
//        return privileges;
//    }
//
//    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
//        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (final String privilege : privileges) {
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }
//
//}
