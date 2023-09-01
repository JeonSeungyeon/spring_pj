package com.spring.project.service;

import com.spring.project.repository.MainRepository;
import com.spring.project.util.SettingValues;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

//import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Properties;

@Service
public class MainService {
    private static final Logger logger = LoggerFactory.getLogger(MainService.class);

    @Autowired
    MainRepository repository;

    // DB
    public void main(HttpServletRequest req, Model model) {

        logger.info("[service => main]");

        int count = repository.main();

        req.setAttribute("count", count);

    }

    // Mail
//    public void sendEmail() {
//
//        final String username = SettingValues.ADMIN; // 네이버 이메일 ID
//        final String password = SettingValues.PW; // 네이버 비밀번호
//        final String host = "smtp.naver.com"; // Google : smtp.gmail.com
//        int port = 465; // 포트번호
//
//        // 메일 내용
//        String recipient = "wall0202222@naver.com"; // 받는 사람의 메일주소를 입력
//        String subject = "이메일 테스트"; // 메일 제목 입력
//        String content = "이메일 테스트"; // 메일 내용 입력
//
//        Properties props = System.getProperties();
//
//        // 정보를 담기 위한 객체 생성
//        // SMTP 서버 정보 설정
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.auth", true);
//        props.put("mail.smtp.ssl.enable", true);
//        props.put("mail.smtp.ssl.trust", host);
//
//        // Session 생성
//        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//            String un = username;
//            String pw = password;
//
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new javax.mail.PasswordAuthentication(un, pw);
//            }
//        });
//        session.setDebug(true); // for debug
//
//        try {
//
//            Message mimeMessage = new MimeMessage(session); // MimeMessage 생성
//            mimeMessage.setFrom(new InternetAddress("wall0202222@naver.com")); // 발신자
//            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); // 수신자
//            mimeMessage.setSubject(subject); // 제목
//            // mimeMessage.setText(body); //내용
//            mimeMessage.setContent(content, "text/html; charset=utf-8");
//            Transport.send(mimeMessage); // javax.mail.Transport.send() 이용
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    // SMS
    public void sendSms() {

        String api_key = "NCSOQX034JG4VCBZ";
        String api_secret = "BAGKECFROWNZB1BAPG8EQRDKLM2BG0KV";
        Message coolsms = new Message(api_key, api_secret);
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("to", "01033639725");
        params.put("from", "01033639725");
        params.put("type", "SMS");
        params.put("text", "SMS 테스트");
        params.put("app_version", "test app 1.2");

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }




}
