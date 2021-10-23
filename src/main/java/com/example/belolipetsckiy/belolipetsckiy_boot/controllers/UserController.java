package com.example.belolipetsckiy.belolipetsckiy_boot.controllers;

import com.example.belolipetsckiy.belolipetsckiy_boot.models.Role;
import com.example.belolipetsckiy.belolipetsckiy_boot.models.User;
import com.example.belolipetsckiy.belolipetsckiy_boot.service.RoleService;
import com.example.belolipetsckiy.belolipetsckiy_boot.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index (Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("users", user);
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("user", userService.index());
        model.addAttribute("allRoles", roleService.getRoles());
        return "user/index";
    }

    @PostMapping
    public String addUser(@ModelAttribute @Valid User user, @RequestParam(value = "checkRoles", required = false) String[] checkRoles) {
        Set<Role> roleSet = new HashSet<>();
        if(checkRoles == null) {
            roleSet.add(new Role(1L,"USER"));
        } else {
            for (String role : checkRoles) {
                roleSet.add(roleService.getRoleByName(role));
            }
        }
        user.setRoles(roleSet);
        userService.update(user);
        return  "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/findOne/{id}")
    @ResponseBody
    public User findOne(@PathVariable("id") Integer id) {

        return userService.show(id);
    }

}
