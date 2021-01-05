package com.example.apijwt.validations;

import static com.example.apijwt.validations.ValidatorUtil.isVaildString;
import static com.example.apijwt.validations.ValidatorUtil.isValidEmail;
import static com.example.apijwt.validations.ValidatorUtil.isValidList;
import com.example.apijwt.exceptions.EmailExistsException;
import com.example.apijwt.exceptions.InvalidFieldsException;
import com.example.apijwt.exceptions.MissingFieldsException;
import com.example.apijwt.models.Phone;
import com.example.apijwt.models.User;
import com.example.apijwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Walter Porfirio
 *
 */
@Component
public class UserValidator implements Validator<User> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhoneValidator phoneValidator;

    @Override
    public void validateRequiredFields(User model) throws Exception {

        if (model.getFirstName() == null) throw new MissingFieldsException();

        if (model.getLastName() == null) throw new MissingFieldsException();

        if (model.getEmail() == null) throw new MissingFieldsException();

        if (model.getPassword() == null) throw new MissingFieldsException();

        if (model.getPhones() == null) throw new MissingFieldsException();
    }

    @Override
    public void validateFieldsValues(User model) throws Exception {

        if (!isVaildString(model.getFirstName())) throw new InvalidFieldsException();

        if (!isVaildString(model.getLastName())) throw new InvalidFieldsException();

        if (!isValidEmail(model.getEmail())) throw new InvalidFieldsException();

        if (!isVaildString(model.getPassword())) throw new InvalidFieldsException();

        if (!isValidList(model.getPhones())) throw new InvalidFieldsException();

        for (Phone phone : model.getPhones()) phoneValidator.validate(phone);
    }

    @Override
    public void validateUniqueFields(User model) throws Exception {
        if (userRepository.findByEmail(model.getEmail()) != null) throw new EmailExistsException();
    }

}
