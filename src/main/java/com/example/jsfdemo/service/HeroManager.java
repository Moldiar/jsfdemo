package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Hero;

@ApplicationScoped
public class HeroManager {

	private List<Hero> hdb = new ArrayList<Hero>();

	public void addHero(Hero hero) {
		Hero nh = new Hero();

		nh.setName(hero.getName());
		nh.setLastName(hero.getLastName());
		nh.setBloodline(hero.getBloodline());
		nh.setBirthSign(hero.getBirthSign());
		nh.setAlignment(hero.getAlignment());
		nh.setEpochOfBirth(hero.getEpochOfBirth());
		nh.setMagicSchematicCode(hero.getMagicSchematicCode());

		hdb.add(nh);
	}

	public void deleteHero(Hero hero) {
		Hero htr = null;
		for (Hero h : hdb) {
			if (hero.getMagicSchematicCode().equals(h.getMagicSchematicCode())) {
				htr = h;
				break;
			}
		}
		if (htr != null) {
			hdb.remove(htr);
		}
	}

	public List<Hero> getAllHeroes() {
		return hdb;
	}
}
