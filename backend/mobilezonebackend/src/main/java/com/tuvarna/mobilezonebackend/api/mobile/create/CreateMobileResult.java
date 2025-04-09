package com.tuvarna.mobilezonebackend.api.mobile.create;

import com.tuvarna.mobilezonebackend.api.base.OperationResult;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateMobileResult implements OperationResult {
    private String id;
}
