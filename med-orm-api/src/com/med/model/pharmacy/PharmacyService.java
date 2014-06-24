package com.med.model.pharmacy;

import java.util.List;

import com.med.model.Service;

public interface PharmacyService extends Service<Pharmacy>{
	List<Pharmacy> getAllPharmacies(PharmacyAssociated pharmacyAssociated);
}
