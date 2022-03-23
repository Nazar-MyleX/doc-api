package com.truck.controller;

import com.truck.PDFFormFieldsDTO;
import com.truck.service.PDFFileService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pdf")
@AllArgsConstructor
public class FileController {
    private final PDFFileService pdfService;

    @SneakyThrows
    @PostMapping
    public ResponseEntity<Object> getPdf(@RequestBody final PDFFormFieldsDTO formFields) {
        pdfService.fillForm(formFields);
        final byte[] file = pdfService.getFile();

        return ResponseEntity.ok(new String(file));
    }
}
