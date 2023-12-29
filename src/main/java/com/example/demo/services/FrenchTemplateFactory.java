package com.example.demo.services;

public class FrenchTemplateFactory implements ITemplate {
    @Override
    public IShippingOrderTemplate createShippingOrderTemplate() {
        IShippingOrderTemplate template = new FrenchShippingOrderTemplate();
        return template;
    }
    @Override
    public IPlacingOrderTemplate createPlaceingOrderTemplate () {
        IPlacingOrderTemplate template = new FrenchPlacingOrderTemplate();
        return template;
    }
}
