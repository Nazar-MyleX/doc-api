package com.truck.service;

import com.itextpdf.text.pdf.*;
import com.truck.PDFFormFieldsDTO;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class PDFServiceImpl implements PDFFileService {
    private static final String FILE_NAME = "file.pdf";
    private static final String FILLED_FILE_NAME = "filled.pdf";

    @Override
    public void fillForm(PDFFormFieldsDTO formFields) {
        try (final FileOutputStream fos = new FileOutputStream(FILLED_FILE_NAME)) {
            final PdfReader reader = new PdfReader(FILE_NAME);
            final PdfStamper stamper = new PdfStamper(reader, fos);
            final AcroFields form = stamper.getAcroFields();
            form.setField("carrier", formFields.getCarrier());
            form.setField("weight", formFields.getWeight());
            form.setField("pallets", formFields.getPallets());
            form.setField("shipper", formFields.getShipper());
            form.setField("shipperAddress", formFields.getShipperAddress());
            form.setField("shipperPOPU", formFields.getShipperPOPU());
            form.setField("receiver", formFields.getReceiver());
            form.setField("receiverAddress", formFields.getReceiverAddress());
            form.setField("receiverPOPU", formFields.getReceiverPOPU());
            form.setField("amount", formFields.getAmount());
            form.setField("comments", formFields.getComments());
            form.setField("cod", formFields.getCod());
            form.setField("name", formFields.getName());
            form.setField("equipment", formFields.getEquipment());
            form.setField("temperature", formFields.getTemperature());
            form.setField("pickUpDate", formFields.getPickUpDate());
            form.setField("pickUpTime", formFields.getPickUpTime());
            form.setField("deliveryDate", formFields.getDeliveryDate());
            form.setField("deliveryTime", formFields.getDeliveryTime());
            stamper.setFormFlattening(true);
            stamper.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] getFile() {
        try(final FileInputStream fis = new FileInputStream(FILLED_FILE_NAME)) {
            final byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            return Base64.getEncoder().encode(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
