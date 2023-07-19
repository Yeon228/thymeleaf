package hello.itemservice.domain.item;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 fast 빠른 배송
 normal : 일반 배송
 slow : 느린 배송
 */
@Data
@RequiredArgsConstructor
public class DeliveryCode {
    private String code;
    private String displayName;
}
