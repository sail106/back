package com.sail.back.security.controller;

import com.sail.back.global.utils.MessageUtils;
import com.sail.back.security.model.dto.request.EmailConfirmRequest;
import com.sail.back.security.model.dto.request.EmailRequest;
import com.sail.back.security.model.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/join-code")
    public ResponseEntity<MessageUtils> sendCodeEmail(
            @RequestBody EmailRequest emailRequest
    ){
        emailService.sendJoinCodeMail(emailRequest.getEmail());
        return ResponseEntity.ok(MessageUtils.success());
    }

    @PostMapping("/code")
    public ResponseEntity<MessageUtils> codeEmail(
            @RequestBody EmailRequest emailRequest
    ){
        emailService.sendCodeMail(emailRequest.getEmail());
        return ResponseEntity.ok(MessageUtils.success());
    }

    @PostMapping("/temp-password")
    public ResponseEntity<MessageUtils> tempPasswordEmail(
            @RequestBody EmailRequest emailRequest
    ){
        emailService.sendTempPasswordMail(emailRequest.getEmail());
        return ResponseEntity.ok(MessageUtils.success());
    }

    @PostMapping("/confirm")
    public ResponseEntity<MessageUtils> confirmNumber(
            @RequestBody EmailConfirmRequest confirmRequest
    ){
        emailService.confirmCode(confirmRequest.getEmail(), confirmRequest.getCode());
        return ResponseEntity.ok(MessageUtils.success());
    }


}
