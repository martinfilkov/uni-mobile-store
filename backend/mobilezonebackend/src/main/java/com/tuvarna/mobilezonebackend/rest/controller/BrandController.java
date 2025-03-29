package com.tuvarna.mobilezonebackend.rest.controller;

import com.tuvarna.mobilezonebackend.api.base.RestApiRoutes;
import com.tuvarna.mobilezonebackend.api.mobile.CreateBrand;
import com.tuvarna.mobilezonebackend.api.mobile.CreateBrandInput;
import com.tuvarna.mobilezonebackend.api.mobile.CreateBrandResult;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BrandController {
    private final CreateBrand createBrand;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created brand"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @PostMapping(RestApiRoutes.BRAND)
    public ResponseEntity<CreateBrandResult> createBrand(CreateBrandInput input) {
        CreateBrandResult output = createBrand.process(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}
