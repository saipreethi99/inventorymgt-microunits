package com.dxctraining.phonemgt.phone.util;

import org.springframework.stereotype.Component;

import com.dxctraining.phonemgt.phone.dto.PhoneDto;
import com.dxctraining.phonemgt.phone.entities.Phone;

@Component
public class PhoneUtil {
    public PhoneDto phoneDto(Phone phone, int supplierId, String supplierName){
        PhoneDto dto = new PhoneDto(phone.getId(),phone.getName(),phone.getStorageSize());
        dto.setSupplierId(supplierId);
        dto.setSupplierName(supplierName);
        return dto;
    }
}