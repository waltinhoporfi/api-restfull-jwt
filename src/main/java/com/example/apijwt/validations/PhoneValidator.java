package com.example.apijwt.validations;

import static com.example.apijwt.validations.ValidatorUtil.isVaildString;
import static com.example.apijwt.validations.ValidatorUtil.isValidPositiveInteger;
import com.example.apijwt.exceptions.InvalidFieldsException;
import com.example.apijwt.exceptions.MissingFieldsException;
import com.example.apijwt.models.Phone;
import org.springframework.stereotype.Component;

/**
 * @author Walter Porfirio
 *
 */
@Component
public class PhoneValidator implements Validator<Phone> {

    @Override
    public void validateRequiredFields(Phone model) throws Exception {

        if (model.getNumber() == null) throw new MissingFieldsException();

        if (model.getArea_code() == null) throw new MissingFieldsException();

        if (model.getCountry_code() == null) throw new MissingFieldsException();
    }

    @Override
    public void validateFieldsValues(Phone model) throws Exception {

        if (!isValidPositiveInteger(model.getNumber())) throw new InvalidFieldsException();

        if (!isValidPositiveInteger(model.getArea_code())) throw new InvalidFieldsException();

        if (!isVaildString(model.getCountry_code())) throw new InvalidFieldsException();
    }

    @Override
    public void validateUniqueFields(Phone model) throws Exception {}

}