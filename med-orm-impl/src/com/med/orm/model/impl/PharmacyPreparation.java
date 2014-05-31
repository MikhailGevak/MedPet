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
	private PharmacyImpl pharmacy;
	@DatabaseField(foreign=true)
	private PreparationImpl preparation;
	
	public PharmacyPreparation(){
		// ORMLite needs a no-arg constructor
	}
	
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(PharmacyImpl pharmacy) {
		this.pharmacy = pharmacy;
	}
	public Preparation getPreparation() {
		return preparation;
	}
	public void setPreparation(PreparationImpl preparation) {
		this.preparation = preparation;
	}
	public String getId() {
		return id;
	}
}
