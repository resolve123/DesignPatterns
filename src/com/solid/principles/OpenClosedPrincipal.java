package com.solid.principles;

import java.util.Random;

/**
 * Closed for modification: New feature getting added to the software componenet should not have to modify existing code.
 * Open for extension: A software componenet should be extendable to add a new feature or to add a new behavior to it.
 * As a result, when the business requirements change then the entity can be extended, but not modified
 *
 * In below code there is discount calculation for Healthinsurance if there is requirement to calculate discount for vehical insurance then
 * we need to modify this code which is again the principal.
 * Solution is HealthInsuranceCustomerProfile class and VehicalInsuranceCustomerProfile should implelent a interface and
 * calculateDscount method should accept that interface.
 */
public class OpenClosedPrincipal {
}

class InsurancePremiumDiscountCalc{
    public int calculatePremium;

    public int calculateDscount(HealthInsuranceCustomerProfile customer){
        if(customer.isLoyalCustomer()){
           return  20;
        }
        return 0;
    }

    /**
     * Addition of this method is against the principal
     * @param customer
     * @return
     */
    public int calculateDscount(VehicalInsuranceCustomerProfile customer){
        if(customer.isLoyalCustomer()){
            return  20;
        }
        return 0;
    }
}

class HealthInsuranceCustomerProfile{
    public boolean isLoyalCustomer(){
        return new Random().nextBoolean();
    }
}

class VehicalInsuranceCustomerProfile{
    public boolean isLoyalCustomer(){
        return new Random().nextBoolean();
    }
}