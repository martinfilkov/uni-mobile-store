package com.tuvarna.mobilezone.rest.controller;

import com.tuvarna.mobilezone.api.base.RestApiRoutes;
import com.tuvarna.mobilezone.api.mobile.CreateBrand;
import com.tuvarna.mobilezone.api.mobile.CreateBrandInput;
import com.tuvarna.mobilezone.api.mobile.CreateBrandResult;
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
