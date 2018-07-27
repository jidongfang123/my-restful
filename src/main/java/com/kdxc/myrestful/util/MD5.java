package com.kdxc.myrestful.util;


import com.kdxc.myrestful.pojo.User;

public class MD5 {

    /**
     * 加工密码，和登录一致。
     *
     * @param
     * @return
     */
    public static User md5(User user) {
        //密码为   username + '#' + pswd，然后MD5
        user.setUpwd(md5Pswd(user.getUphone(), user.getUpwd()));
        return user;
    }

    /**
     * 字符串返回值
     *
     * @param
     * @param
     * @return
     */
    public static String md5Pswd(String uphone, String upwd) {
        upwd = String.format("%s#%s", uphone, upwd);
        upwd = MathUtil.getMD5(upwd);
        return upwd;
    }
}
