package com.briup.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
    /**
     * 服务网关   沙箱环境都是这个
     */
    public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 应用id  后期可以替换成自己的id
     */
    public static String appId = "2016101600698792";

    /**
     * 用户私钥   后期替换成自己的私钥
     */
    public static String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCy7JGpk9DLKPWTjJ3W28GitOPZGSRh/7tsE6ORFx8ZPVrAkxs1n7yq3+WvYBVuxoAjYhuFifrpw61sjQMnOrmLyjlViziSyy+j7fNwznHzL6O8uyH7sXWLUkIZ1bE9Yuf1VHuH5htIEo/m5cOaNrTg5ujWIgTs4Sx9ovuFVa8XwPDXUAo/esYwQjFaYTTSd++B6flJb5a40z6uPDRs5HkMi+EOjLkofy9Uthk715r+wpcXWRQKYMffMVBLeDEwnZTthZHsuyWqK4KX1Ak1qxEfonO9nf8lXs+tH5ir5+Q30qUQcCl+X4/Dtl9wXRhQxTTWEoWA/m18kq1ogs/he5NnAgMBAAECggEADKrzJS5x+fBMcsXh5vRoITztZNGC4e1ZN62sRvl8Gi1d34SKyKEmmnJ/sIr8+XrUV6z6hdnfCe3wuV7CemSN/ney13uj5cC8/r46HiJ/rtgQn6wgG9HUoKiSRYH7qnz2L0hr9pM0G0Y1KgPadXCqHcI7ee2uq5bFr596b1ZBr0y7CGnh+ZgPW755V5SiTx9MuClWG3GPvPsW/7LaX/n5OYO6FDctJogQGhStF104sH0IPZT47luU7bIf90pDlsNDt1ufowwoFihjQE5AMQ7Rd0UHf4xocqimbNdPC9lMRlOFf//DR3pLOIXvP7snRDcURC1O485WotVaBeJxNDdUAQKBgQD8azWCU31sYIafM3H03M/jbjq8gubZBpVH8VmtBfqrxhC91WNKPSxMnqMOHgpOniQ/+iN9zxr6m0Hgbgl5qK5Drh+s65/s6vsEAFNM7sufyXfycodChSBF5d1Dte9PT/1ilkEhfRcwrS/WTlJoC/VHwdFJnC0VlIAujvGHvNnh1wKBgQC1dmzv5UG2So5FBJ5fiBsJBFfwmDUlDzeQoBfSR8bd2vPglARINE4bFuoKc75J2wGcRDRYQTP3IDxdsLrqrKHwcN5yUathOd3g+yv2k7o6RQkHOFXasPTEnsb4+s6k0OR/MYHUZ9EM1gU5X0LMjUopXlHWUKrPA6i85+L8vcLI8QKBgHjjc4YOLERqWi8GuW33Ds0yboj3/E02POpuqW8XLP11Z3EzMFFOyNeNJjRNqMwMKvpE9xh6xsX882jj6j/MzGD3lI4Bbt9NjphU+5Ad0YGeQIbp2OO/1DwFoZmbGZiXi5fatCiwuxmB6CYv7oGMMJWEOpKRbHooW9dweDZ0+LiTAoGASo0t8l1A4xC8ZJSiMGNtoAW9z2XpJ6GZ1XxAbS75//nNii2lmLiMgkqmusaUnikw/y9yRfP70oLW6jMKiBGGso7chSEShO5OPvlSNYq5zui/7cxyUVe0J/eHjZEVRtdfmPYQ/d/tHhXrrYd6nSlLF7Xdb2xS0JwTPhESy312wjECgYByy/ADgeOlMeu7O4NC0xeb6xVPE/SuVNJGrgAsz1LGpWG8o/idvTAauidJERjPi7+Gir981p05xTcoahHKSiY1Iw7J99TE1tJ8sd/BU6x5PdFAKRWkYSwg5v+UT2vlDRZ6Znc7BKThcad8lwNfhk88WcXEDs/ISABeGH8OouShCA==";

    /**
     * 发送数据的格式 目前只能为json
     * 使用servlet去进行支付测试
     */
    public static String format = "json";

    /**
     * 设置字符集编码 目前只能为utf-8
     */
    public static String charset = "utf-8";

    /**
     * 支付宝公钥 后期替换成自己的支付宝公钥
     */
    public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzRkNnpgN/26ndfQptk6r5YCSK7MtJ8sLEYWaBf4dd/Do2AGjMA3V7rg16rXHgBTFAy43QgHosMAOjh7vdyUMi1LiIE6+vLRz1pamiZ4yYP80tPbiZyf8CmQOlp2leCmEzFjsJUXhtW7anSoww7O+NsWrldTDV0FXT7bsluGElU9A2fNqGCCbnaqF7nOe1aeurUc9ynNLuvCcrcuMIrqK7V1zPvYszgLZp+72LBN9eOOyLNu4mxqvDmUTm1WJ+AR/t5CxAIcwy+eSPefF0S4k3E5PqZFl7XzYb+PV0mZEKKGnmZ+SYpVcn3JkfAnqQ6zNoh+S+0oMNoj2lW+Cvprg5QIDAQAB";

    /**
     * 支付宝签名 目前是 RSA2
     */
    public static String signType = "RSA2";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数， 必须外网可以正常访问
     */
    public static String return_url = "http://47.100.138.244:8080/estore/index.jsp";

    public static AlipayClient getAlipayClient() {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.serverUrl, AlipayConfig.appId,
                AlipayConfig.privateKey, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.publicKey,
                AlipayConfig.signType);
        return alipayClient;
    }
}
