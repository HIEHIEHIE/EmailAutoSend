package io.transwarp.email;

public class MyRunnable implements Runnable {
    String content;
    //传入实体类，也可以传入其他参数，因为实体类包含了邮件内容和邮箱号码，后面要用
    public MyRunnable(String content){
        this.content = content;
    }
    @Override
    public void run() {
        System.out.println("进入邮件发送");
        SendMail sendMail = new SendMail();
        sendMail.send(content);
    }
}