package movie.info.validators;

import movie.info.model.impl.User;
import movie.info.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        String required          = messageSource.getMessage("userForm.required", null, LocaleContextHolder.getLocale());
        String sizeUsername      = messageSource.getMessage("userForm.size.username", null, LocaleContextHolder.getLocale());
        String sizePassword      = messageSource.getMessage("userForm.size.password", null, LocaleContextHolder.getLocale());
        String duplicateUsername = messageSource.getMessage("userForm.duplicate.username", null, LocaleContextHolder.getLocale());
        String differentPassword = messageSource.getMessage("userForm.different.password", null, LocaleContextHolder.getLocale());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", required);
        if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "", sizeUsername);
        }

        if (userService.getByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "", duplicateUsername);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", required);
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "", sizePassword);
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "", differentPassword);
        }
    }
}
