package com.example.demo.services;

import com.example.demo.models.Customer;

public interface INotifier {
    String send (TemplateSubstitute template);
}
