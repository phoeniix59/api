//package com.project.api.registration;
//
//import com.project.api.model.User;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Calendar;
//import java.util.Date;
//
//@Entity
//@Getter
//@Setter
//public class VerificationToken {
//    private static final int EXPIRATION = 60 * 24;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String token;
//
//    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "user_id")
//    private User user;
//
//    private Date expiryDate;
//
//    public VerificationToken() {
//        super();
//    }
//
//    public VerificationToken(final String token) {
//        super();
//
//        this.token = token;
//        this.expiryDate = calculateExpiryDate(EXPIRATION);
//    }
//
//    public VerificationToken(final String token, final User user) {
//        super();
//
//        this.token = token;
//        this.user = user;
//        this.expiryDate = calculateExpiryDate(EXPIRATION);
//    }
//
//    private Date calculateExpiryDate(int expiryTimeInMinutes) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(new Date().getTime());
//        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
//        return new Date(cal.getTime().getTime());
//    }
//
//    public void updateToken(final String token) {
//        this.token = token;
//        this.expiryDate = calculateExpiryDate(EXPIRATION);
//    }
//
//    // standard constructors, getters and setters
//}
