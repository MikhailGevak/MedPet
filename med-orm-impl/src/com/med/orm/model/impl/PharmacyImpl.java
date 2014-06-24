package com.med.orm.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.med.model.pharmacy.Pharmacy;
import com.med.model.preparation.Preparation;
import com.med.model.preparation.PreparationAssociated;
import com.med.orm.model.impl.builder.PharmacyBuilder;

@DatabaseTable(tableName = "pharmacy")
public class PharmacyImpl extends AbstractEntityImpl implements Pharmacy,
		PreparationAssociated {
	@DatabaseField(id = true)
	private String id;
	@DatabaseField
	private String name;
	@DatabaseField
	private String address;
	@ForeignCollectionField
	private Collection<PharmacyPreparation> pharmacyPreparations;

	public PharmacyImpl() {
		// ORMLite needs a no-arg constructor
	}

	public PharmacyImpl(PharmacyBuilder builder) {
		this.name = builder.getName();
		this.address = builder.getAddress();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<PharmacyPreparation> getPharmacyPreparations() {
		return pharmacyPreparations;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public List<Preparation> getPreparations() {
		List<Preparation> preparations = new ArrayList<>();

		for (PharmacyPreparation pharmacyPreparation : pharmacyPreparations) {
			preparations.add(pharmacyPreparation.getPreparation());
		}

		return preparations;
	}
}
