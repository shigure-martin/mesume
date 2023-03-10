package com.celebritiesGathering.request;

import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * @author shaoxiong.zhan
 */
@Data
public class OrderRequest {
    private Sort.Direction direction = Sort.Direction.ASC;
    private String property;
}
