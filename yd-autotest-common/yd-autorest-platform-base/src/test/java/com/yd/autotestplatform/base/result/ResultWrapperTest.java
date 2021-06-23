package com.yd.autotestplatform.base.result;

import com.yd.autotestplatform.base.enums.StateCodeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-22 9:46
 * @Email: 664720125@qq.com
 */
@SpringBootTest
class ResultWrapperTest {
    @Test
    void getSuccessBuilder() {
        boolean success = (ResultWrapper.getSuccessBuilder().build().getCode() == StateCodeEnum.SUCCESS.getCode());
        System.out.println(success);
        assert success;
        success = (ResultWrapper.getSuccessBuilder().build().getMsg() == StateCodeEnum.SUCCESS.getMsg());
        System.out.println(success);
        assert success;
    }

    @Test
    void getFailBuilder() {
        boolean fail = (ResultWrapper.getFailBuilder().build().getCode() == StateCodeEnum.FAIL.getCode());
        System.out.println(fail);
        System.out.println(StateCodeEnum.FAIL.getCode());
        assert fail;
        fail = (ResultWrapper.getFailBuilder().build().getMsg() == StateCodeEnum.FAIL.getMsg());
        System.out.println(fail);
        assert fail;
    }
}
