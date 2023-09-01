package com.spring.project.controller;

import com.spring.project.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainService service;

    // DB
    @RequestMapping("/main")
    public String main(HttpServletRequest req, Model model) {
        logger.info("[url => main]");

//        service.main(req, model);

        List<String> myList = new ArrayList<String>();
        myList.add("항목 1");
        myList.add("항목 2");
        myList.add("항목 3");

        Gson gson = new Gson();
        String jsonMyList = gson.toJson(myList);

        req.setAttribute("jsonMyList", jsonMyList);


        return "main/test";
    }

    // Mail
    @RequestMapping("/mail")
    public String mail(HttpServletRequest req, Model model) {
        req.setAttribute("mail", "성공?");
//        service.sendEmail();

        return "main/mail";
    }

    // SMS
    @RequestMapping("/sms")
    public String sms(HttpServletRequest req, Model model) {

        req.setAttribute("sms", "성공?");
        service.sendSms();

        return "main/sms";
    }

}
