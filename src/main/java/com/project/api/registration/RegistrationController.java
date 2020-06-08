//package com.project.api.registration;
//
//import org.springframework.stereotype.Controller;
//
//@Controller("/registration")
//public class RegistrationController {
//
////    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
////
////    @Autowired
////    private UserService userService;
////
////    @Autowired
////    private ApplicationEventPublisher eventPublisher;
////
////    @Autowired
////    private MessageSource messages;
//
////    @Autowired
////    private Environment env;
////
////    @Autowired
////    private MailSender mailSender;
////
////    @Autowired
////    private UserSecurityService securityService;
////
////    @PostMapping("/user/registration")
////    public GenericResponse registerUserAccount(
////            @Valid UserDto accountDto, HttpServletRequest request) {
////        LOGGER.debug("Registering user account with information: {}", accountDto);
////        User registered = userService.registerNewUserAccount(accountDto);
////        if (registered == null) {
////            throw new UserAlreadyExistException();
////        }
////        String appUrl = "http://" + request.getServerName() + ":" +
////                request.getServerPort() + request.getContextPath();
////
////        eventPublisher.publishEvent(
////                new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
////
////        return new GenericResponse("success");
////    }
////
////    @GetMapping("/registrationConfirm")
////    public String confirmRegistration
////            (WebRequest request, Model model, @RequestParam("token") String token) {
////
////        Locale locale = request.getLocale();
////
////        VerificationToken verificationToken = userService.getVerificationToken(token);
////        if (verificationToken == null) {
////            String message = messages.getMessage("auth.message.invalidToken", null, locale);
////            model.addAttribute("message", message);
////            return "redirect:/badUser.html";
////        }
////
////        User user = verificationToken.getUser();
////        Calendar cal = Calendar.getInstance();
////        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
////            model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
////            model.addAttribute("expired", true);
////            model.addAttribute("token", token);
////            return "redirect:/badUser.html";
////        }
////
////        user.setEnabled(true);
////        userService.saveRegisteredUser(user);
////        model.addAttribute("message", messages.getMessage("message.accountVerified", null, locale));
////        return "redirect:/login";
////    }
////
////    @GetMapping("/user/resendRegistrationToken")
////    public GenericResponse resendRegistrationToken(
////            HttpServletRequest request, @RequestParam("token") String existingToken) {
////        VerificationToken newToken = userService.generateNewVerificationToken(existingToken);
////
////        User user = userService.getUser(newToken.getToken());
////        String appUrl =
////                "http://" + request.getServerName() +
////                        ":" + request.getServerPort() +
////                        request.getContextPath();
////        SimpleMailMessage email = constructResendVerificationTokenEmail(appUrl, request.getLocale(), newToken, user);
////        mailSender.send(email);
////
////        return new GenericResponse(
////                messages.getMessage("message.resendToken", null, request.getLocale()));
////    }
////
////    private SimpleMailMessage constructResendVerificationTokenEmail
////            (String contextPath, Locale locale, VerificationToken newToken, User user) {
////        String confirmationUrl =
////                contextPath + "/registrationConfirm.html?token=" + newToken.getToken();
////        String message = messages.getMessage("message.resendToken", null, locale);
////        SimpleMailMessage email = new SimpleMailMessage();
////        email.setSubject("Resend Registration Token");
////        email.setText(message + " rn" + confirmationUrl);
////        email.setFrom(Objects.requireNonNull(env.getProperty("support.email")));
////        email.setTo(user.getEmail());
////        return email;
////    }
////
////    @PostMapping("/user/resetPassword")
////    public GenericResponse resetPassword(HttpServletRequest request,
////                                         @RequestParam("email") String userEmail) {
////        User user = userService.findByEmail(userEmail);
////        if (user == null) {
////            throw new UserNotFoundException();
////        }
////        String token = UUID.randomUUID().toString();
////        userService.createPasswordResetTokenForUser(user, token);
////        final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
////        mailSender.send(constructResetTokenEmail(appUrl,
////                request.getLocale(), token, user));
////        return new GenericResponse(
////                messages.getMessage("message.resetPasswordEmail", null,
////                        request.getLocale()));
////    }
////
////    private SimpleMailMessage constructResetTokenEmail(
////            String contextPath, Locale locale, String token, User user) {
////        String url = contextPath + "/user/changePassword?token=" + token;
////        String message = messages.getMessage("message.resetPassword",
////                null, locale);
////        return constructEmail("Reset Password", message + " \r\n" + url, user);
////    }
////
////    private SimpleMailMessage constructEmail(String subject, String body,
////                                             User user) {
////        SimpleMailMessage email = new SimpleMailMessage();
////        email.setSubject(subject);
////        email.setText(body);
////        email.setTo(user.getEmail());
////        email.setFrom("me@localhost");
////        return email;
////    }
////
////    @GetMapping("/user/changePassword")
////    public String showChangePasswordPage(Locale locale, Model model, @RequestParam("token") String token) {
////        String result = securityService.validatePasswordResetToken(token);
////        if (result != null) {
////            String message = messages.getMessage("auth.message." + result, null, locale);
////            return "login" + "&message=" + message;
////        } else {
////            model.addAttribute("token", token);
////            return "updatePassword";
////        }
////    }
////
////    @PostMapping("/user/savePassword")
////    public GenericResponse savePassword(final Locale locale, @Valid PasswordDto passwordDto) {
////        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        userService.changeUserPassword(user, passwordDto.getNewPassword());
////        return new GenericResponse(messages.getMessage("message.resetPasswordSuc", null, locale));
////    }
////
////    @PostMapping("/user/updatePassword")
////    @PreAuthorize("hasRole('READ_PRIVILEGE')")
////    public GenericResponse changeUserPassword(Locale locale, @RequestParam("password") String password, @RequestParam("oldpassword") String oldPassword) {
////        User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
////
////        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
////            throw new InvalidOldPasswordException();
////        }
////        userService.changeUserPassword(user, password);
////        return new GenericResponse(messages.getMessage("message.updatePasswordSuc", null, locale));
////    }
//}
