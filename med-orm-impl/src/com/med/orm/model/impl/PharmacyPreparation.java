package com.med.orm.model.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.med.orm.pharmacy.Pharmacy;
import com.med.orm.preparation.Preparation;

@DatabaseTable(tableName="pharmacy_preparation")
public class PharmacyPreparation {
	@DatabaseField(id = true)
	private String id;
	@DatabaseField(foreign=true)
	private Pharmacy pharmacy;
	@DatabaseField(foreign=true)
	private Preparation preparation;
	
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public Preparation getPreparation() {
		return preparation;
	}
	public void setPreparation(Preparation preparation) {
		this.preparation = preparation;
	}
	public String getId() {
		return id;
	}
}
