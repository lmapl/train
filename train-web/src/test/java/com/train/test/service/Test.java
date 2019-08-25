package com.train.test.service;

import com.alibaba.fastjson.JSON;
import com.train.web.dao.Image;
import com.train.web.dao.UserCompanyRequest;
import com.train.web.dao.UserTeacherRequest;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/7 14:54
 * Description: ${DESCRIPTION}
 */
public class Test {
    public static void main(String[] args) throws Exception {
       /* UserCompanyRequest userCompanyRequest = new UserCompanyRequest();
        userCompanyRequest.setAutograph("IhgZksMhjCjrdu9+8gLlOiOZrwlBaHmdXVULBh0O6MvyviUcYnK2DHqEgn+Ydp+FpSGbJ5xrfuO4IYtuFLcoyO+LlNWFu637IlNORT+TFAkL0MKqUeiqRNapVgEFSsT0wk7UZOZXKmU6Q2NBCVoATiB+E5JpgrgWgVibZChdrpc=");
        userCompanyRequest.setNickName("1");
        userCompanyRequest.setPortrait("http://www.baidu.com");
        userCompanyRequest.setPosition("heb河北aaaa");
        userCompanyRequest.setLat(new BigDecimal(100.01));
        userCompanyRequest.setLon(new BigDecimal(200));
        userCompanyRequest.setIntroduction("河北啊啊啊啊shanc河北啊啊啊啊擅长gaishaiz");
        userCompanyRequest.setScale("100->1000");
        userCompanyRequest.setEstablishmentTime(System.currentTimeMillis());
        userCompanyRequest.setContactInfon("0539-10200202");
        userCompanyRequest.setCertificate("http://www.baidu.com");
        userCompanyRequest.setContactPeple("马先生");

        List<Image> imageList = new ArrayList<>();
        Image image = new Image();
        image.setHigh(10);
        image.setWidth(10);
        image.setImageUrl("aaaaaaaaaa");
        Image image1 = new Image();
        image1.setHigh(20);
        image1.setWidth(20);
        image1.setImageUrl("bbbbbbbbb");
        imageList.add(image);
        imageList.add(image1);
        userCompanyRequest.setIntroductionPortraits(imageList);

        System.out.println(JSON.toJSON(userCompanyRequest));*/



        UserTeacherRequest userTeacherRequest = new UserTeacherRequest();
        userTeacherRequest.setFreeVideo("河北啊啊啊啊shanc河北啊啊啊啊擅长gaishaiz");
        userTeacherRequest.setIntroduction("http://www.baidu.com");
        userTeacherRequest.setPosition("heb河男aaaa");
        userTeacherRequest.setTeachingAge(10);
        userTeacherRequest.setSubject(2);
        userTeacherRequest.setPortrait("http://www.baidu.com");
        userTeacherRequest.setNickName("1111");
        userTeacherRequest.setAutograph("IhgZksMhjCjrdu9+8gLlOiOZrwlBaHmdXVULBh0O6MvyviUcYnK2DHqEgn+Ydp+FpSGbJ5xrfuO4IYtuFLcoyO+LlNWFu637IlNORT+TFAkL0MKqUeiqRNapVgEFSsT0wk7UZOZXKmU6Q2NBCVoATiB+E5JpgrgWgVibZChdrpc=");
        userTeacherRequest.setLat(new BigDecimal(100.00));
        userTeacherRequest.setLon(null);

        System.out.println(JSON.toJSON(userTeacherRequest));
    }


    public String split(String input, String[] listOfTokens) throws Exception {
        if (StringUtils.isEmpty(input)) {
            throw new Exception("input must not be null");
        }
        if (listOfTokens == null || listOfTokens.length <=0) {
            throw new Exception("listOfTokens must not be null");
        }

        //寻找最短分割字符串
        String min = listOfTokens[0];
        for(String token : listOfTokens){
            if(min.length() >= token.length()){
                min = token;
            }
        }

        //统一替换字符
        for (String token : listOfTokens) {
            if (input.contains(token)) {
                input = input.replace(token, min);
            }
        }
        //分割
        String[] result = input.split(min);

        return JSON.toJSONString(result);
    }
}
