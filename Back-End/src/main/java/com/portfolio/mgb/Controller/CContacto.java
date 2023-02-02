package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoContacto;
import com.portfolio.mgb.Entity.Contacto;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SContacto;
import org.apache.commons.lang3.StringUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
@RequestMapping("/contacto")


//Local
@CrossOrigin//(origins = "https://newpro-32aab.web.app")

public class CContacto {

    @Autowired
    SContacto sContacto;
    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/send")
    public ResponseEntity<?> create(@RequestBody dtoContacto dtoCont) {
        if (StringUtils.isBlank(dtoCont.getEmail())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoCont.getCuerpo())) {
            return new ResponseEntity(new Mensaje("El cuerpo del email es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        try {
            //Envio el imail
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("lezcano.emanuel.contacto@gmail.com");
            message.setTo(dtoCont.getEmail());
            message.setSubject("CONSULTA RECIBIDA !!!");
            message.setText("Gracias por contactarme, en breve me comunico con usted !!!");
            emailSender.send(message);
            message.setFrom("lezcano.emanuel.contacto@gmail.com");
            message.setTo("emanuellezcano999@gmail.com");
            message.setSubject("CONSULTA DESDE TU PAGINA WEB !!!");
            message.setText("Recibiste una consulta de '" + dtoCont.getEmail()+ "', con el siguiente mensaje: "+  dtoCont.getCuerpo());
            emailSender.send(message);
            
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error al enviar mail" + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
            
        Contacto contacto = new Contacto(dtoCont.getEmail(), dtoCont.getAsunto(), dtoCont.getCuerpo());
        sContacto.save(contacto);

        return new ResponseEntity(new Mensaje("Email enviado y guardado!!"), HttpStatus.OK);

    }

}
