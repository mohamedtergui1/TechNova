package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getAllUsers() {
        ModelAndView mav = new ModelAndView("index");
        List<User> users = userService.getUsers();
        mav.addObject("users", users);
        return mav;
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/";  // Redirect to users page
        }

        userService.saveUser(user);
        return "redirect:/";  // Redirect to users page
    }



    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/";  // Redirect to users page
        }
        user.setId(id);  // Set ID to ensure we're updating the correct user
        userService.updateUser(user);
        return "redirect:/";  // Redirect to users page
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";  // Redirect to users page
    }
}
