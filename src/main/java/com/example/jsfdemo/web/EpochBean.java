package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.validator.ValidatorException;

import com.example.jsfdemo.domain.Epoch;
import com.example.jsfdemo.service.EpochManager;

@SessionScoped
@Named("epochBean")
public class EpochBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Epoch epoch = new Epoch();

	private ListDataModel<Epoch> epochs = new ListDataModel<Epoch>();

	@Inject
	private EpochManager em;

	public Epoch getEpoch() {
		return epoch;
	}

	public void setEpoch(Epoch epoch) {
		this.epoch = epoch;
	}
	
	public ListDataModel<Epoch> getAllEpochs() {
		epochs.setWrappedData(em.getAllEpochs());
		return epochs;
	}

	public String addEpoch() {
		em.addEpoch(epoch);
		return "showEpochs";
	}

	public String delEpoch() {
		Epoch etd = epochs.getRowData();
		em.deleteEpoch(etd);
		return null;
	}

	public String getEpochName()
	{
		return epoch.getName();
	}
	
	public void uniqueName(FacesContext context, UIComponent component,
			Object value) {
		String name = (String) value;

		for (Epoch e : em.getAllEpochs()) {
			if (e.getName().equalsIgnoreCase(name)) {
				FacesMessage mes = new FacesMessage(
						"There is already an Epoch by that name!");
				mes.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(mes);
			}
		}
	}
}
