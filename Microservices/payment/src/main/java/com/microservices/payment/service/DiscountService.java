package com.microservices.payment.service;


import com.microservices.payment.dto.DiscountDTO;
import com.microservices.payment.dto.PricelistDTO;

import java.util.Set;

public interface DiscountService {

    DiscountDTO getDiscount(long id);

    Set<DiscountDTO> getAllDiscounts();

    DiscountDTO createDiscount(DiscountDTO request);
}
