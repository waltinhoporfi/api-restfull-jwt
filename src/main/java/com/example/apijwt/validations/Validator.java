package com.example.apijwt.validations;

/**
 * @author Walter Porfirio
 *
 * @param <MODEL>
 */
public interface Validator<MODEL> {

    default void validate(MODEL model) throws Exception {
        this.validateRequiredFields(model);
        this.validateFieldsValues(model);
        this.validateUniqueFields(model);
    }

    public void validateRequiredFields(MODEL model) throws Exception;

    public void validateFieldsValues(MODEL model) throws Exception;

    public void validateUniqueFields(MODEL model) throws Exception;

}
