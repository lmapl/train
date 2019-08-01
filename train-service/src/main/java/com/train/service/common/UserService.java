package com.train.service.common;

import com.train.domain.bean.LoginInfo;
import com.train.domain.bean.RegisterInfo;
import com.train.domain.entity.User;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 11:47
 * Description: ${DESCRIPTION}
 */
public interface UserService {

    /**
     * 注册
     * @param registerInfo
     * @return
     */
    boolean register(RegisterInfo registerInfo);

    /**
     * 手机登录验证
     * @param loginInfo
     * @return
     */
    User mobileLoginVerify(LoginInfo loginInfo);

    /**
     * 登录结果记录
     * @param user
     * @return
     */
    String login(User user);

    /**
     * 退出登录
     * @param autograph
     * @return
     */
    Boolean loginOut(String autograph);
}
