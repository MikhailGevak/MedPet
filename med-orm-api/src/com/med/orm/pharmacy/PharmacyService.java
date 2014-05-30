package com.med.orm.pharmacy;

import java.util.List;

import com.med.orm.Service;

public interface PharmacyService extends Service<Pharmacy>{
	List<Pharmacy> getAllPharmacies(PharmacyAssociated pharmacyAssociated);
}
