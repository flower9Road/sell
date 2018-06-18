package com.xf.imti.utils;

import com.xf.imti.enums.CodeEnum;
import lombok.Data;

/**
 * Created by 874879659 on 2018/4/23.
 */
@Data
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
