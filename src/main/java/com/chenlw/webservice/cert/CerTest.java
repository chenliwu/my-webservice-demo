package com.chenlw.webservice.cert;

/**
 * @author chenlw 2020-10-21
 * @since
 */
public class CerTest {

    public static void main(String[] args) {
        CerTest test = new CerTest();
        //生成 keystore 文件
        test.getKeyStore();
        //生成 *.cer 证书文件
        test.export();
        System.out.println("=========生成证书完毕=========");
    }

    public void execCommand(String[] arstringCommand) {
        for (int i = 0; i < arstringCommand.length; i++) {
            System.out.print(arstringCommand[i] + " ");
        }
        try {
            Runtime.getRuntime().exec(arstringCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void execCommand(String arstringCommand) {
        try {
            Runtime.getRuntime().exec(arstringCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 生成 *.keystore
     */
    public void getKeyStore() {
        String[] arstringCommand = new String[]{
                "cmd ", "/k",
                "start", // cmd Shell命令
                "keytool",
                "-genkey", // -genkey表示生成密钥
                "-validity", // -validity指定证书有效期(单位：天)，这里是365天
                "365",
                "-keysize",//     指定密钥长度
                "1024",
                "-alias", // -alias指定别名，这里是everygold
                "everygold",
                "-keyalg", // -keyalg 指定密钥的算法 (如 RSA DSA（如果不指定默认采用DSA）)
                "RSA",
                "-keystore", // -keystore指定存储位置，这里是d:/leslie.keystore
                "d:/leslie.keystore",
                "-dname",// CN=(名字与姓氏), OU=(组织单位名称), O=(组织名称), L=(城市或区域名称),
                // ST=(州或省份名称), C=(单位的两字母国家代码)"
                "CN=(leslie), OU=(everygold), O=(pujinwang), L=(Guangzhou), ST=(Guangdong), C=(CN)",
                "-storepass", // 指定密钥库的密码(获取keystore信息所需的密码)
                "123456",
                "-keypass",// 指定别名条目的密码(私钥的密码)
                "123456",
                "-v"// -v 显示密钥库中的证书详细信息
        };
        execCommand(arstringCommand);
    }

    /**
     * 导出证书文件
     */
    public void export() {

        String[] arstringCommand = new String[]{
                "cmd ", "/k",
                "start", // cmd Shell命令
                "keytool",
                "-export", // - export指定为导出操作
                "-keystore", // -keystore指定keystore文件，这里是d:/leslie.keystore
                "d:/leslie.keystore",
                "-alias", // -alias指定别名，这里是ss
                "everygold",
                "-file",//-file指向导出路径
                "d:/leslie.cer",
                "-storepass",// 指定密钥库的密码
                "123456"
        };
        execCommand(arstringCommand);

    }
}
