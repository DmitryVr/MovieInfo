package movie.info.validators;

import movie.info.model.impl.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MovieValidator implements Validator {
    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return Movie.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Movie movie = (Movie) object;

        String required        = messageSource.getMessage("userForm.required", null, LocaleContextHolder.getLocale());
        String selectedFile    = messageSource.getMessage("userForm.file.select", null, LocaleContextHolder.getLocale());


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameRussian", "", required);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "", required);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "", required);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "director", "", required);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", required);

        // если запись новая
        if (movie.getId() == 0) {
            if (movie.getFile().getSize() == 0) {
                errors.rejectValue("file", "", selectedFile);
            }
        }
    }
}