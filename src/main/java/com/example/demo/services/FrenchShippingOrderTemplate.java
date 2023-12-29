package com.example.demo.services;

import com.example.demo.models.Customer;

public class FrenchShippingOrderTemplate implements IShippingOrderTemplate,TemplateSubstitute{
    @Override
    public String substitute(Customer customer) {
        return "Cher "+ customer.getUsername() +", votre expédition est terminée.";
    }
}
