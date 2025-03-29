package com.tuvarna.mobilezonebackend.api.mobile;

import com.tuvarna.mobilezonebackend.api.base.OperationResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Brand;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateBrandResult implements OperationResult {
    private String id;
}
