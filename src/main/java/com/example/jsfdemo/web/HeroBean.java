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
import com.example.jsfdemo.domain.Hero;
import com.example.jsfdemo.service.HeroManager;

@SessionScoped
@Named("heroBean")
public class HeroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Hero hero = new Hero();

	private ListDataModel<Hero> heroes = new ListDataModel<Hero>();

	@Inject
	private HeroManager pm;

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public ListDataModel<Hero> getAllHeroes() {
		heroes.setWrappedData(pm.getAllHeroes());
		return heroes;
	}

	public String addHero() {
		pm.addHero(hero);
		return "showHeroes";
	}

	public String delHero() {
		Hero htd = heroes.getRowData();
		pm.deleteHero(htd);
		return null;
	}

	public void uniqueMSC(FacesContext context, UIComponent component,
			Object value) {
		String msc=(String) value;
		
		for(Hero h:pm.getAllHeroes())
		{
			if(h.getMagicSchematicCode().equalsIgnoreCase(msc))
			{
				FacesMessage mes=new FacesMessage("Person with this Magic Schematic Code already exists in database");
				mes.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(mes);
			}
		}
	}
}
