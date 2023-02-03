package io.transwarp.email;

import java.io.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class EmailApplication {
    private static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(6);

    public static void main(String[] args) throws InterruptedException, IOException {
        while(true) {
            new CheckStatus().runCheckStatus();
            String filePath = "/opt/pg-shell/autoSendMail/checkResult";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String strLine = null;
            String content = "";
            while (null != (strLine = reader.readLine())) {
                content += strLine;
            }
            scheduledExecutorService.submit(new MyRunnable(content));
            Thread.sleep(21600000);
        }

    }

}
