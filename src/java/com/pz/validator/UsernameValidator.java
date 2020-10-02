
package com.pz.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator(value = "usernameValidator")
public class UsernameValidator implements Validator {
 
    @Override
    public void validate(FacesContext facesContext,
            UIComponent uiComponent, Object value) throws
            ValidatorException {
        Pattern pattern = Pattern.compile("^[a-z]+[0-9]+[0-9]+[0-9]+[0-9]");
        Matcher matcher = pattern.matcher(
                (CharSequence) value);
        HtmlInputText htmlInputText
                = (HtmlInputText) uiComponent;
        String label;
        if (htmlInputText.getLabel() == null
                || htmlInputText.getLabel().trim().equals("")) {
            label = htmlInputText.getId();
        } else {
            label = htmlInputText.getLabel();
        }
        if (!matcher.matches()) {
            FacesMessage facesMessage
                    = new FacesMessage(label
                            + ": korisnicko ime ne zadovoljava kriteriume");
            throw new ValidatorException(facesMessage);
        }
    }
}
