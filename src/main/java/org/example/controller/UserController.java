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
    private static final String REDIRECT_HOME = "redirect:/";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
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
            return REDIRECT_HOME;
        }
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("success", "User added successfully");
        return REDIRECT_HOME;
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            return REDIRECT_HOME;
        }
        user.setId(id);
        userService.updateUser(user);
        redirectAttributes.addFlashAttribute("success", "User updated successfully");
        return REDIRECT_HOME;
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("success", "User deleted successfully");
        return REDIRECT_HOME;
    }
}
