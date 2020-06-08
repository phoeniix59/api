package com.project.api.model;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "user", schema = "public")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", length = 75)
    private String firstName;

    @Column(name = "last_name", length = 80)
    private String lastName;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "email", unique = true, length = 115)
    private String email;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//    private Collection<Role> roles;

    @Column(name= "enabled")
    private Boolean enabled;

    public User() {
        super();
        this.enabled=false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(final Collection<Role> roles) {
//        this.roles = roles;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public Boolean isEnabled() { return enabled; }
}
