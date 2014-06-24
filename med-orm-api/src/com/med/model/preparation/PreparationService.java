package com.med.model.preparation;

import java.util.List;

import com.med.model.Service;

public interface PreparationService extends Service<Preparation>{
	List<Preparation> getAllPreparations(PreparationAssociated pharmacyAssociated);
}
