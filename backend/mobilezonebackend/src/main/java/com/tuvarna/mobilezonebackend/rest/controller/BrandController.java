package com.tuvarna.mobilezonebackend.rest.controller;

import com.tuvarna.mobilezonebackend.api.base.RestApiRoutes;
import com.tuvarna.mobilezonebackend.api.brand.create.CreateBrand;
import com.tuvarna.mobilezonebackend.api.brand.create.CreateBrandInput;
import com.tuvarna.mobilezonebackend.api.brand.create.CreateBrandResult;
import com.tuvarna.mobilezonebackend.api.brand.delete.DeleteBrandById;
import com.tuvarna.mobilezonebackend.api.brand.delete.DeleteBrandByIdInput;
import com.tuvarna.mobilezonebackend.api.brand.delete.DeleteBrandByIdResult;
import com.tuvarna.mobilezonebackend.api.brand.edit.EditBrand;
import com.tuvarna.mobilezonebackend.api.brand.edit.EditBrandInput;
import com.tuvarna.mobilezonebackend.api.brand.edit.EditBrandResult;
import com.tuvarna.mobilezonebackend.api.brand.get.GetBrandById;
import com.tuvarna.mobilezonebackend.api.brand.get.GetBrandByIdInput;
import com.tuvarna.mobilezonebackend.api.brand.get.GetBrandByIdResult;
import com.tuvarna.mobilezonebackend.core.operations.brand.GetAllBrandsOperation;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BrandController {
    private final CreateBrand createBrand;
    private final GetAllBrandsOperation getAllBrandsOperation;
    private final GetBrandById getBrandById;
    private final DeleteBrandById deleteBrandById;
    private final EditBrand editBrand;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created brand"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @PostMapping(RestApiRoutes.BRAND)
    public ResponseEntity<CreateBrandResult> createBrand(@RequestBody CreateBrandInput input) {
        CreateBrandResult output = createBrand.process(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully extracted all brands"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @GetMapping(RestApiRoutes.BRAND)
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = getAllBrandsOperation.process();
        return ResponseEntity.ok(brands);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully extracted brand by id"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @GetMapping(RestApiRoutes.BRAND_ID)
    public ResponseEntity<GetBrandByIdResult> getBrandById(@PathVariable(name = "id") String id) {
        GetBrandByIdInput input = GetBrandByIdInput.builder()
                .id(id)
                .build();
        GetBrandByIdResult output = getBrandById.process(input);
        return ResponseEntity.ok(output);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted brand"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @DeleteMapping(RestApiRoutes.BRAND_ID)
    public ResponseEntity<Void> deleteBrandById(@PathVariable(name = "id") String id) {
        DeleteBrandByIdInput input = DeleteBrandByIdInput.builder()
                .id(id)
                .build();
        deleteBrandById.process(input);
        return ResponseEntity.noContent().build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully edited brand"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @PutMapping(RestApiRoutes.BRAND_ID)
    public ResponseEntity<EditBrandResult> editBrand(@PathVariable(name = "id") String id, @RequestBody EditBrandInput request) {
        EditBrandInput input = request.toBuilder()
                .id(id)
                .build();
        EditBrandResult output = editBrand.process(input);
        return ResponseEntity.ok(output);
    }
}
