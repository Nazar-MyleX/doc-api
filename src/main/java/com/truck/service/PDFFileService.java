package com.truck.service;

import com.truck.PDFFormFieldsDTO;

public interface PDFFileService {
    void fillForm(PDFFormFieldsDTO formFields);
    byte[] getFile();
}
