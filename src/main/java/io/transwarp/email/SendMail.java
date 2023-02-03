package io.transwarp.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendMail {

    public void send(final String content) {
        new Thread(() -> {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            SimpleMailMessage message = new SimpleMailMessage();
            //邮件设置
            javaMailSender.setPort(587);
            javaMailSender.setHost("smtp.qq.com");
            //自己的邮箱 需要去开通邮箱协议
            javaMailSender.setUsername("***");
            javaMailSender.setPassword("mwyfgpfnhmnrgecd");
            //邮件内容
            message.setSubject("test");
            message.setText(content);
            //发送给谁
            message.setTo("***");
            message.setFrom("***");
            javaMailSender.send(message);
            System.out.println("发送成功");
        }).start();
    }

}
