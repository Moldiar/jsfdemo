package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Bloodline;
import com.example.jsfdemo.service.BloodlineManager;

@SessionScoped
@Named("bloodlineBean")
public class BloodlineBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Bloodline bloodline = new Bloodline();

	private ListDataModel<Bloodline> bloodlines = new ListDataModel<Bloodline>();

	@Inject
	private BloodlineManager bm;

	public Bloodline getBloodline() {
		return bloodline;
	}

	public void setBloodline(Bloodline bloodline) {
		this.bloodline = bloodline;
	}
	
	public ListDataModel<Bloodline> getAllBloodlines() {
		bloodlines.setWrappedData(bm.getAllBloodlines());
		return bloodlines;
	}

	public String addBloodline() {
		bm.addBloodline(bloodline);
		return "showBloodlines";
	}

	public String delBloodline() {
		Bloodline btd = bloodlines.getRowData();
		bm.deleteBloodline(btd);
		return null;
	}
	
	public void uniqueHGS(FacesContext context, UIComponent component,
			Object value) {
		String hematexGene = (String) value;

		for (Bloodline b : bm.getAllBloodlines()) {
			if (b.getHematexGene().equalsIgnoreCase(hematexGene)) {
				FacesMessage mes = new FacesMessage(
						"There is already a Bloodline with that Hematex Gene Signature!");
				mes.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(mes);
			}
		}
	}
}
