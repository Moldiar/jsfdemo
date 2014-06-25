package com.example.jsfdemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("mscValidator")
public class MSCValidator implements Validator {
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String msc = (String) value;

		if (msc.length() < 6) {
			FacesMessage mes = new FacesMessage();
			mes.setDetail("Magic Schematic Code needs to contain at least 6 symbols!");
			mes.setSummary("Magic Schematic Code needs to contain at least 6 symbols!");
			mes.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mes);
		}
	}
}
