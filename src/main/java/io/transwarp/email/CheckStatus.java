package io.transwarp.email;

import java.io.IOException;

public class CheckStatus {
    public void runCheckStatus() throws IOException, InterruptedException {
        String bashCommand = "/opt/pg-shell/checkStatus.sh";  //①
        Runtime runtime = Runtime.getRuntime();
        Process pro = runtime.exec(bashCommand);  //②
        int status = pro.waitFor();  //③
        if (status != 0){  //④
            System.out.println("check node status error.");
            return;
        }
        System.out.println("check node status success.");
    }
}
