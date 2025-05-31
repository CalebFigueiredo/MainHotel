package com.caleb.MainHotel.Controller;

import com.caleb.MainHotel.model.User;
import com.caleb.MainHotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Mostrar o formulário de cadastro
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Cria objeto vazio para o formulário
        return "register"; // vai renderizar register.html
    }

    // Processar cadastro
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        boolean created = userService.createUser(user);
        if (created) {
            return "register_success"; // Criar essa página também para sucesso
        } else {
            model.addAttribute("error", "Email já cadastrado.");
            return "register"; // volta para o formulário mostrando erro
        }
    }
}
