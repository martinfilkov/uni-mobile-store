package com.tuvarna.mobilezonebackend.rest.controller;

import com.tuvarna.mobilezonebackend.api.base.RestApiRoutes;
import com.tuvarna.mobilezonebackend.api.mobile.create.CreateMobile;
import com.tuvarna.mobilezonebackend.api.mobile.create.CreateMobileInput;
import com.tuvarna.mobilezonebackend.api.mobile.create.CreateMobileResult;
import com.tuvarna.mobilezonebackend.api.mobile.delete.DeleteMobileById;
import com.tuvarna.mobilezonebackend.api.mobile.delete.DeleteMobileByIdInput;
import com.tuvarna.mobilezonebackend.api.mobile.edit.EditMobile;
import com.tuvarna.mobilezonebackend.api.mobile.edit.EditMobileInput;
import com.tuvarna.mobilezonebackend.api.mobile.edit.EditMobileResult;
import com.tuvarna.mobilezonebackend.api.mobile.get.GetMobileById;
import com.tuvarna.mobilezonebackend.api.mobile.get.GetMobileByIdInput;
import com.tuvarna.mobilezonebackend.api.mobile.get.GetMobileByIdResult;
import com.tuvarna.mobilezonebackend.core.operations.mobile.GetAllMobilesOperation;
import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MobileController {
    private final CreateMobile createMobile;
    private final GetAllMobilesOperation getAllMobiles;
    private final GetMobileById getMobileById;
    private final DeleteMobileById deleteMobileById;
    private final EditMobile editMobile;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created mobile"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @PostMapping(RestApiRoutes.MOBILE)
    private ResponseEntity<CreateMobileResult> createMobile(@RequestBody CreateMobileInput input) {
        CreateMobileResult output = createMobile.process(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully extracted all mobiles"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @GetMapping(RestApiRoutes.MOBILE)
    private ResponseEntity<List<Mobile>> getAllMobiles() {
        List<Mobile> output = getAllMobiles.process();
        return ResponseEntity.ok(output);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully extract mobile by id"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @GetMapping(RestApiRoutes.MOBILE_ID)
    private ResponseEntity<GetMobileByIdResult> getMobileById(@PathVariable(name = "id") String id) {
        GetMobileByIdInput input = GetMobileByIdInput.builder()
                .id(id)
                .build();
        GetMobileByIdResult output = getMobileById.process(input);
        return ResponseEntity.ok(output);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully extract mobile by id"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @DeleteMapping(RestApiRoutes.MOBILE_ID)
    private ResponseEntity<GetMobileByIdResult> deleteMobileById(@PathVariable(name = "id") String id) {
        DeleteMobileByIdInput input = DeleteMobileByIdInput.builder()
                .id(id)
                .build();
        deleteMobileById.process(input);
        return ResponseEntity.noContent().build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully extract mobile by id"),
            @ApiResponse(responseCode = "401", description = "User not authorized")
    })
    @PutMapping(RestApiRoutes.MOBILE_ID)
    private ResponseEntity<EditMobileResult> editMobile(@PathVariable(name = "id") String id,
                                                        @RequestBody EditMobileInput request) {
        EditMobileInput input = request.toBuilder()
                .id(id)
                .build();
        EditMobileResult output = editMobile.process(input);
        return ResponseEntity.ok(output);
    }
}
