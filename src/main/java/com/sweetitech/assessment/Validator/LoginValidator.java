package com.sweetitech.assessment.Validator;

import com.sweetitech.assessment.Domain.User;
import com.sweetitech.assessment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {

            return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user =(User) o;
        if (!userRepository.existsByEmailAndPassword(user.getEmail(),user.getPassword()))
        {
            errors.reject("error.invalid.user.password");
        }
    }
}
