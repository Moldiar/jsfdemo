package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Bloodline;

@ApplicationScoped
public class BloodlineManager {

	private List<Bloodline> bdb = new ArrayList<Bloodline>();

	public void addBloodline(Bloodline bl) {
		Bloodline nb = new Bloodline();

		nb.setName(bl.getName());
		nb.setPower(bl.getPower());
		nb.setHematexGene(bl.getHematexGene());

		bdb.add(nb);
	}
	
	public void deleteBloodline(Bloodline bl) {
		Bloodline btr = null;
		for (Bloodline b : bdb) {
			if (bl.getName().equals(b.getName())) {
				btr = b;
				break;
			}
		}
		if (btr != null) {
			bdb.remove(btr);
		}
	}
	
	public List<Bloodline> getAllBloodlines() {
		return bdb;
	}
}
