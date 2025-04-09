package com.tuvarna.mobilezonebackend.api.brand.edit;

import com.tuvarna.mobilezonebackend.api.base.OperationResult;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class EditBrandResult implements OperationResult {
    private String id;
}
