package com.example.demo.services;

public class EnglishTemplateFactory implements ITemplate {

    @Override
    public IShippingOrderTemplate createShippingOrderTemplate() {
        IShippingOrderTemplate template = new EnglishShippingOrderTemplate();
        return template;
    }
    @Override
    public IPlacingOrderTemplate createPlaceingOrderTemplate () {
        IPlacingOrderTemplate template = new FrenchPlacingOrderTemplate();
        return template;
    }
}
