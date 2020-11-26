package org.tarot.tower.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: org.tarot.tower.controller
 * @author: 王子豪
 * @date: 2020/11/23 10:02
 * @description: 邮件发送测试类
 * 1. 在 pom 文件中配置依赖
 * <dependency>
 *      <groupId>org.springframework.boot</groupId>
 *      <artifactId>spring-boot-starter-mail</artifactId>
 * </dependency>
 * 2. 在 application.yml 中配置 spring.mail
 * #  mail:
 * #    host: smtp.163.com
 * #    username: localhost
 * #    password: 123456
 * #    properties:
 * #      mail.smtp.auth: true
 * #      mail.smtp.starttls.enable: true
 * #      mail.smtp.starttls.required: true
 */
@RestController
@RequestMapping("/mail")
public class MailTestController {

//    @Autowired
//    private JavaMailSender sender;
//
//    @RequestMapping("/simple")
//    //发送简单邮件
//    public void sendSimpleMail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        //发送者
//        message.setFrom("");
//        //接收者
//        message.setTo("");
//        //邮件主题
//        message.setSubject("主题");
//        //邮件内容
//        message.setText("内容");
//        //发送邮件
//        sender.send(message);
//    }
//
//    @RequestMapping("/html")
//    //发送富文本邮件
//    public void sendHtmlMail() {
//        //支持更复杂的邮件格式和内容
//        MimeMessage mimeMessage = sender.createMimeMessage();
//        //处理 MimeMessage 辅助类
//        MimeMessageHelper helper = null;
//        try {
//            helper = new MimeMessageHelper(mimeMessage, true);
//            //发送者
//            helper.setFrom("");
//            //接收者
//            helper.setTo("");
//            //邮件主题
//            helper.setSubject("主题");
//            //邮件内容(第二个参数为true代表html文本)
//            helper.setText("<h1 style=''>内容</h1>", true);
//            sender.send(mimeMessage);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping("/html-attach")
//    //发送富文本带附件
//    public void sendHtmlWithAttach() {
//        //支持更复杂的邮件格式和内容
//        MimeMessage mimeMessage = sender.createMimeMessage();
//        //处理 MimeMessage 辅助类
//        MimeMessageHelper helper = null;
//        try {
//            helper = new MimeMessageHelper(mimeMessage, true);
//            //发送者
//            helper.setFrom("");
//            //接收者
//            helper.setTo("");
//            //邮件主题
//            helper.setSubject("主题");
//            //邮件内容(第二个参数为true代表html文本)
//            helper.setText("<h1 style=''>内容</h1>", true);
//            File attachment = new File("favicon.ico");
//            helper.addAttachment("attachment.jpg", attachment);
//            sender.send(mimeMessage);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}
