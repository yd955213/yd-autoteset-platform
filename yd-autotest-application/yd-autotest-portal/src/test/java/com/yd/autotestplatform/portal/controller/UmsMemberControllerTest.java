package com.yd.autotestplatform.portal.controller;

import com.google.gson.Gson;
import com.yd.autotestplatform.service.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.service.ums.entity.dto.UmsMemberRegisterParamDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-21 12:22
 * @Email: 664720125@qq.com
 */
@SpringBootTest
@AutoConfigureMockMvc
class UmsMemberControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @Nullable
    void testRegister() throws Exception {
        UmsMemberRegisterParamDTO umsMemberRegisterParamDTO = new UmsMemberRegisterParamDTO();
        umsMemberRegisterParamDTO.setUsername("yd1");
        umsMemberRegisterParamDTO.setPassword("123");
        umsMemberRegisterParamDTO.setEmail("yd@163.com");
        umsMemberRegisterParamDTO.setNote("这是一个测试人员");
        Gson gson = new Gson();

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/ums-member/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(umsMemberRegisterParamDTO))
            )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("测试返回：" + mvcResult.getResponse().getContentAsString());
    }


    @Test
    void login() throws Exception {
        UmsMemberLoginParamDTO umsMemberLoginParamDTO = new UmsMemberLoginParamDTO();
        umsMemberLoginParamDTO.setUserName("yd");
        umsMemberLoginParamDTO.setPassWord("123");
        Gson gson = new Gson();

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/ums-member/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(umsMemberLoginParamDTO))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println("测试返回：" + mvcResult.getResponse().getContentAsString());
    }
}
