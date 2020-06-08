//package com.project.api.model;
//
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Collection;
//
//@Entity
//@Table(name = "role", schema = "public")
//public class Role implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;
//
//    @ManyToMany
//    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;
//
//    private String name;
//
//    public Role() {
//        super();
//    }
//
//    public Role(final String name) {
//        super();
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(final String name) {
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Collection<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(final Collection<User> users) {
//        this.users = users;
//    }
//
//    public Collection<Privilege> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(final Collection<Privilege> privileges) {
//        this.privileges = privileges;
//    }
//}
