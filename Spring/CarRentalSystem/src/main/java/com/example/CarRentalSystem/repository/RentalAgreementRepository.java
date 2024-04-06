package com.example.CarRentalSystem.repository;

import com.example.CarRentalSystem.data.RentalAgreement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalAgreementRepository {
    private final List<RentalAgreement> rentalAgreements;

    public RentalAgreementRepository(List<RentalAgreement> rentalAgreements) {
        this.rentalAgreements = rentalAgreements;
    }

    public RentalAgreement add(RentalAgreement rentalAgreement) {
        rentalAgreements.add(rentalAgreement);
        return rentalAgreement;
    }

    public List<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }
}
