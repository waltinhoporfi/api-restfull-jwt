package com.example.apijwt.validations;

import static com.example.apijwt.validations.ValidatorUtil.isVaildString;
import com.example.apijwt.exceptions.InvalidFieldsException;
import com.example.apijwt.exceptions.UnauthorizedException;
import com.example.apijwt.security.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Walter Porfirio
 *
 */
@Component
public class TokenValidator implements Validator<String> {

    @Autowired
    JwtToken jwtToken;

    @Override
    public void validate(String model) throws Exception {
        Validator.super.validate(model);
        jwtToken.doValidateToken(model);
    }

    @Override
    public void validateRequiredFields(String model) throws Exception {
        if (model == null) throw new UnauthorizedException();
    }

    @Override
    public void validateFieldsValues(String model) throws Exception {
        if (!isVaildString(model)) throw new InvalidFieldsException();
    }

    @Override
    public void validateUniqueFields(String model) throws Exception {}

}