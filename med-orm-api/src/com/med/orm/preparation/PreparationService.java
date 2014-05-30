package com.med.orm.preparation;

import java.util.List;

import com.med.orm.Service;

public interface PreparationService extends Service<Preparation>{
	List<Preparation> getAllPreparations(PreparationAssociated pharmacyAssociated);
}
