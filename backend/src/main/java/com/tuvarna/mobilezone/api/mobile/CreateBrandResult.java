package com.tuvarna.mobilezone.api.mobile;

import com.tuvarna.mobilezone.api.base.OperationResult;
import com.tuvarna.mobilezone.persistence.entity.Brand;
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
