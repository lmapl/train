package com.train.test.service;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/7 14:54
 * Description: ${DESCRIPTION}
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        String[] listOfTokens = new String[] { "--", "ghi", ":", "-", "rst" };
        String input = "abc---def::ghi::jkl:mno-,,-,";
        String result = test.split(input, listOfTokens);
        System.out.println(result);
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
