package com.example.StorehouseDBJ.controllers;

import com.example.StorehouseDBJ.dto.JwtRequest;
import com.example.StorehouseDBJ.dto.JwtResponse;
import com.example.StorehouseDBJ.services.JwtTokenService;
import com.example.StorehouseDBJ.models.User;
import com.example.StorehouseDBJ.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserEmail(), authRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            log.info("Authentication error, incorrect username or password");
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUserEmail());
        String token = jwtTokenService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        if (userService.isUsernameAlreadyInUse(user.getEmail())) {
            model.addAttribute("emailError", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "registration";
        }

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!user.getPassword().equals(user.getRepeatPassword())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        model.addAttribute("noErrors");
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("shops", user.getShops());
        return "user-info";
    }
}
