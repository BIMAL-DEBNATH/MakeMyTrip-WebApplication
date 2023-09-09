package com.example.MakeMyTrip.Services;

import com.example.MakeMyTrip.Models.User;
import com.example.MakeMyTrip.Repository.UserRepository;
import com.example.MakeMyTrip.requestDTO.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender emailSender; //for send mail
    public String addUser(AddUserDto addUserDto) {

        User user=User.builder()
                .age(addUserDto.getAge())
                .name(addUserDto.getName())
                .emailId(addUserDto.getEmailId())
                .build();
        userRepository.save(user);

        //****
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String body = "Hi! "+user.getName()+"\n" +
                "Welcome to Make your Trip Website. Book your flights, buses and trains conviniently here";

        mailMessage.setSubject("Welcome to Make your Trip");
        mailMessage.setFrom("dummyemaili720@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setText(body);

        emailSender.send(mailMessage);
//***
        return "User has been added successfully!";
    }
}
