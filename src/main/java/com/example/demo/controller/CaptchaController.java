package com.example.demo.controller;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: xutu
 * @since: 2024/6/28 9:14
 */
@RestController
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = defaultKaptcha.createText();
        System.out.println(capText);
        request.getSession().setAttribute("captcha", capText);

        BufferedImage bi = defaultKaptcha.createImage(capText);
        ImageIO.write(bi, "jpg", response.getOutputStream());
    }

    @PostMapping("/validateCaptcha")
    public String validateCaptcha(@RequestParam("captcha") String captcha, HttpServletRequest request) {
        String sessionCaptcha = (String) request.getSession().getAttribute("captcha");
        if (sessionCaptcha != null && sessionCaptcha.equals(captcha)) {
            return "Captcha validation success!";
        } else {
            return "Captcha validation failed!";
        }
    }


}
