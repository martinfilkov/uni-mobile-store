package com.tuvarna.mobilezonebackend.api.mobile.edit;

import com.tuvarna.mobilezonebackend.api.base.OperationResult;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EditMobileResult implements OperationResult {
    private String id;
}
