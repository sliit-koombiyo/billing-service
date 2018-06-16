package com.koombiyo.controllers;

import com.koombiyo.models.Bill;
import com.koombiyo.models.BillItem;
import com.koombiyo.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Damma on 12-Jun-18.
 */
@RestController
@RequestMapping("/billing")
public class BillController {

    @Autowired
    BillRepository billRepository;

    // TODO: I have to add the react front end as the origin - Damsith IT16037434
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/get-total", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bill getTotal(@RequestBody Bill bill) {
        System.out.println(bill);
        double tot = 0;
        for(BillItem item: bill.items){
            System.out.println(item.price);
            tot += item.price * item.quantity;
        }
        bill.total = tot;
        return bill;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bill create(@RequestBody Bill bill) {
        System.out.println(bill);
        bill.paid = true;
        billRepository.save(bill);
        return bill;
    }
}
