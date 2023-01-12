package com.lolineet.standard.exception;


/**
 *
 * @author YUKI.N
 * @since 2023-01-09
 */
public class ExceptionCode {
    /**
     *  Web相关 [700-799]区间
     */

    /**
     * 未登录
     */
    public static final int NO_LOGIN = 701;
    /**
     * 访问频率限制
     */
    public static final int REQUEST_FREQUENCY_LIMIT = 702;
    /**
     * 登录过期
     */
    public static final int LOGIN_EXPIRE = 703;
    /**
     * 未寻找到企业
     */
    public static final int ENTERPRISE_NOT_FIND = 704;


    /**
     * 用户查询失败
     */
    public static final int USER_NOT_FOUND = 710;
    /**
     * 认证服务异常
     */
    public static final int AUTHENTICATION_ERROR = 720;
    /**
     * 角色查询失败
     */
    public static final int ROLE_NOT_FOUND = 730;
    /**
     * 微信未绑定
     */
    public static final int WE_CHAT_NOT_BIND = 740;
    /**
     * 角色变更
     */
    public static final int ROLE_CHANGED = 750;
    /**
     * 微信错误
     */
    public static final int WE_CHAT_ERROR = 760;


    /**
     * excel错误
     */
    public static final int EXCEL_EXCEPTION = 770;

    /**
     * 文件错误
     */
    public static final int FILE_EXCEPTION = 790;

    /**
     * 数据库操作失败
     */
    public static final int SQL_EXCEPTION = 997;
    /**
     * 数据库操作失败
     */
    public static final int MAIL_EXCEPTION = 998;
    /**
     * 签名验证不通过
     */
    public static final int API_SIGN_EXCEPTION = 994;
    /**
     * 数据未找到
     */
    public static final int ENTITY_NOTFOUND_EXCEPTION = 780;
    /**
     * 无效非法的参数
     */
    public static final int INVALID_PARAM_EXCEPTION = 700;
    /**
     * token验证错误
     */
    public static final int TOKEN_ILLEGAL_EXCEPTION = 990;
    /**
     * 验证码不正确
     */
    public static final int INVALID_VERIFY_CODE = 989;
    /**
     * 系统提示
     */
    public static final int SYS_TIP = 988;

    public static final int INVALID_SYSTEM_CLOCK = 10101;
    /**
     * 访问受限制
     */
    public static final int VISIT_LIMIT = 987;
    /**
     * 系统异常
     */
    public static final int SYS = 986;

    /**
     * 登陆设备码不正确
     **/
    public static final int DEVICE_ERROR = 600;

    /**
     *  Netty相关 [800-899]区间
     */

    /**
     * Netty Server异常
     **/
    public static final int NETTY_EXCEPTION = 700;


    /**
     *  Kafka相关 [900-999]区间
     */


    /**
     * 未定义异常
     **/
    public static final int SYS_UNIDENTIFIED = -1;

    public static final String INSERT_FAIL = "新增失败";
    public static final String UPDATE_FAIL = "修改失败";
    public static final String DELETE_FAIL = "删除失败";
}
