package realshovanshah.controller;

import realshovanshah.model.User;
import realshovanshah.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String registerView() {
        return "register";
    }

    @PostMapping()
    public String registerUser(@ModelAttribute User user, Model model) {
        String error = null;

        if (!userService.isUsernameAvailable(user.getUsername())) {
            error = "The username already exists.";
        }

        if (error == null) {
            int rowsAdded = userService.createUser(user);
            if (rowsAdded < 0) {
                error = "There was an error signing you up. Please try again.";
            }
        }

        if (error == null) {
            model.addAttribute("success", true);
        } else {
            model.addAttribute("error", error);
        }

        return "register";
    }
}
