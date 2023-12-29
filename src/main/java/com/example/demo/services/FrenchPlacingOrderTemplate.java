package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.models.Product;

import java.util.Vector;

public class FrenchPlacingOrderTemplate implements IPlacingOrderTemplate,TemplateSubstitute {
    @Override
    public String substitute(Customer customer, Vector<Product> products) {
        String productsNames = "";
        for (int i = 0; i < products.size(); i++) {
            productsNames += products.get(i).getName();
            if (i != products.size() - 1) {
                productsNames += ", ";
            }
        }
        return "Cher " + customer.getUsername() + ", votre réservation de l'objet "+ productsNames +" est confirmée. Merci d'utiliser notre magasin :)";
    }
}
