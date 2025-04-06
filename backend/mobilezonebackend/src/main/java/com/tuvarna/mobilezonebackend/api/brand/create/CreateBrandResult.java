package com.tuvarna.mobilezonebackend.api.brand.create;

import com.tuvarna.mobilezonebackend.api.base.OperationResult;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateBrandResult implements OperationResult {
    private String id;
}
