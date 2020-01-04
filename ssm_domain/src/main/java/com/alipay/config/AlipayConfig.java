package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 陈旺生
 * @create 2019-11-22 11:48
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * 说明：
 *  以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *  该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101300674837";

	// 应用私钥（商户私钥），您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCk07+D6Sc0lOLn7YsnmnBEu2apsrUmmZ6+9VCG+4UXL7oWXsuNw+wZWV7cV1u1ngZHt/wiDD94Fc7xuXh4B1coZGIIja5UoGedUZ97NmQQ5jC6eBZxXLpVDb/FsLk/4eB6rc9ouxIjwwbpIalsPvwPZHmDjBCuJXilxOJZ7Z8d+0JdPPLnuVZQ5AJtzjsIGZzry40iURMpf35wzv4ibNTtin7APXMNQzHvbM4vJl6DUEAJvZazmlh1NTNlwnNvHqdofc+oznncF9F4EKIeuDDDiJveIn9m8ileKazGQR4vUFAzTI+M6ay/7EI68Q+wlbvR6aLmpSD1ZO01tCyUd3ULAgMBAAECggEAVL+vbELYbrfTB49jCmTlLuHwgnapoARC1ErMMetnXimjE9d/8A95+PqzxLWCKRrsfbnDATqs87C67B0CLS0RCmq64U0AAvFK9V+/kZnAz9Ob4HTYjUcxY4QjQ6F/TrJ0On/d8iqlxA+GIR62vzqPXda6iAHfnbsUkp9uBvEf7Eityuv7oWrKhNgqjc+w2mvK8uMbSkpGYjTfLSYWUWfCuUonVnV9/mTZaID0b8a5fh9zAEhCbLkXbBS6PMyn0Go3vhOf0VvAXiG0Doe2j+ymXC2AZ0yMvIiO3q0uNRY4/mQPlRoTv4LyCWdE9SxZs3t2Jc8XmPAj+CJLc0yZX4qVQQKBgQDeVcnT8o8hq2ekj8Mt/KTNyNJsD4iTQoGoxdriDbE61jTHu3gec/uUnJhg+oS8Sepc1vZS0wUBr8x6zyWXbznO8p1rnSmsR++PQUr5D/gMJv47hes9YvqLa36UI4WbY7h8w9IQ6as8nrlTyNUGCw4HX3tCehTDOld6p+BcaGELqwKBgQC9yNIeYJPIgwkIJjbCfF4HuOyy71qC1MWPVWKfEwXa6r2dq4VtfN4jQBuU5Rx0RywI1iUPtUDKH9oBvprRlVoLiJu0weL628Jw0BlNzcdGSICWO4G3iN5zyDsAbeI3tVVGgAkClmZF6t6hjz/tar/+pV409+WjCX2hMC1oj8rcIQKBgDpCdpmQRMtI0+a+OSHSwwidZ+4i/+G+mqUz+1Ai0F8fhEMWL7qjH7hodFFtM9z27W+YcIFxhC1V+Jnxr+MHpTlCP9fUHfhj/TUnodKzyYa9rP7B78ttJUPlTgzZZgg60Dv5QBFoeZNv8BYxWQi1Wt65uV3JCanCnuuoE9WDEHLzAoGAQC4wuKsqbw25OTNLI3xRhEUKbvy43DO+V9mlT2xsd3sZAsAlkEBBEySz7yeH9t62yoo44FYIghJBdIOT8bqTSAE7vuYur20wFVyaohAsCt2r9qJLHNlBeWBGa7+9V9+P5haYdXKNRanG/lXmZZDLOv+Lm1gWJYupG6CiSpEOJmECgYEAxDnfEa8MXEPXUQQD9pwRl/rYnyhvr4JqYN1sdDXH/oUapS5dy72bTjItjmknpQ4TGRH0g1XJO03WbyJQlCc2CEwxyWFOwgH8AjXmUCQNX3EYG37Ts2Po7hc7wmCwGgBkNscU4/zw/T7UFcQuJduTP1aE1syeeLODA6dUwTqMIyc=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiblgqZ/wcdAu0M67H4V+kxC443RtMJc4TC1BZxLCI5QnH4vlFzJP5ZPZZMqV/TZi5LhvZzjtNXM+zMhdCYCJUwQp04Wgd6atkeynsdmJjWHtbH4ds+JkFi2f44l0I8kSZpKO6TpDvN3qg9sQ4rxbKkHa6E2/bflo/lycplzNPNtjDLf4XqFrdsCIoqLpCMXZ5KWQ1k+OZ4ho52xasEN7OJEt+vTnL0JigCYAZedOsmU+XVUR4S7ISkcSo01C4qihVtezIwoSN8Lg7P3I2Gs+cRNeCWDIQIsg/CuwLipbFskQWPOF5YrO6Ol+v/CEkFSpGY1KWMUNs3kSJbevOmNfjQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/ssm_web/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/ssm_web/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
