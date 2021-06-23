package com.yd.autotestplatform.portal.controller;

import com.google.gson.Gson;
import com.yd.autotestplatform.base.result.ResultWrapper;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberLoginParamDTO;
import com.yd.autotestplatform.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.yd.autotestplatform.ums.entity.response.UmsMemberLoginResponseParam;
import com.yd.autotestplatform.util.JwtToken;
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
    private String token;
    private Gson gson;
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
        gson = new Gson();

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/ums-member/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(umsMemberLoginParamDTO))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println("测试返回：" + contentAsString);

        /*
        获取token
         */
        gson = new Gson();
        ResultWrapper<UmsMemberLoginResponseParam> resultWrapper = gson.fromJson(contentAsString, ResultWrapper.class);
        token = resultWrapper.getData().getToken();
    }

    @Test
    void edit() throws Exception {
        String userName = JwtToken.parseToken(token);

        UmsMemberRegisterParamDTO umsMemberRegisterParamDTO = new UmsMemberRegisterParamDTO();
        umsMemberRegisterParamDTO.setUsername(userName);
        umsMemberRegisterParamDTO.setEmail("66472@qq.com");

        gson = new Gson();
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/ums-member/edit")
                .content(gson.toJson(umsMemberRegisterParamDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

    }

    @Test
    void logout(){

    }
}
