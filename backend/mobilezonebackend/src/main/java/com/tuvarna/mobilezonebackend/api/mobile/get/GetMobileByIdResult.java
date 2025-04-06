package com.tuvarna.mobilezonebackend.api.mobile.get;

import com.tuvarna.mobilezonebackend.api.base.OperationResult;
import com.tuvarna.mobilezonebackend.persistence.entity.Mobile;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetMobileByIdResult implements OperationResult {
    private Mobile mobile;
}
