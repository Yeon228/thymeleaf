package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

public class MessageCodesResolverTest {
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();
    //DefaultMessageCodesResolver 기본 생성 규칙
    //객체 오류의 경우
    //code + . + object name
    //code

    //필드 오류의 경우
    // code . objectName , field
    // code . field
    // code . fieldType
    // code

    @Test
    void messageCodesREsolverObject(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        Assertions.assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        Assertions.assertThat(messageCodes).containsExactly("required.item.itemName","required.itemName", "required.java.lang.String","required");
    }
}
