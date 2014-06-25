package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Epoch;

@ApplicationScoped
public class EpochManager {

	private List<Epoch> edb = new ArrayList<Epoch>();

	public void addEpoch(Epoch epoch) {
		Epoch ne = new Epoch();

		ne.setName(epoch.getName());
		ne.setDescription(epoch.getDescription());
		ne.setStartDate(epoch.getStartDate());
		ne.setEndDate(epoch.getEndDate());
		ne.setTurningPoint(epoch.getTurningPoint());

		edb.add(ne);
	}

	public void deleteEpoch(Epoch epoch) {
		Epoch etr = null;
		for (Epoch e : edb) {
			if (epoch.getName().equals(e.getName())) {
				etr = e;
				break;
			}
		}
		if (etr != null) {
			edb.remove(etr);
		}
	}

	public List<Epoch> getAllEpochs() {
		return edb;
	}
}
