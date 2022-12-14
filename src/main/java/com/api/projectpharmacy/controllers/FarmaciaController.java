package com.api.projectpharmacy.controllers;

import com.api.projectpharmacy.services.FarmaciaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {
    final FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }
}
