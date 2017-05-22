package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.model.Role;
import tapplication.model.User;
import tapplication.service.DataHelperService;
import tapplication.service.RoleServiceImpl;
import tapplication.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpench on 23.03.17.
 */
@Controller
public class LoginController extends CoreController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private DataHelperService dataHelperService;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public Object redirect(Model model) {
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("categoriesmap", dataHelperService.getCategoryMap());
        model.addAttribute("carouselproducts", dataHelperService.getCarouselProductDtoList());
        model.addAttribute("bestSellers", dataHelperService.getBestSellers());
        return "index";
    }

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userslist";
    }

    @RequestMapping(value = { "/user" }, method = RequestMethod.GET)
    public String userDetails(ModelMap model) {

        User user = userService.findBySSO(getPrincipal());
        model.addAttribute("user", user);
        model.addAttribute("loggedinuser", getPrincipal());
        return "user";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId", "Non unique username");
            result.addError(ssoError);
            return "registration";
        }
        /*
        * if user doing self registration, then role will be USER
        *
        * */
        if(user.getRole() == null) {
            List<Role> roles = (List<Role>) model.get("roles");
            Role userRole = new Role();
            for (Role role : roles) {
                if (role.getType().equals(Role.UserRoleType.USER.name())) {
                    userRole = role;
                }
            }
            user.setRole(userRole);
        }
        userService.saveUser(user);

        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "redirect:/";
    }


    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    @RequestMapping(value = { "/edit-details-user-{ssoId}" }, method = RequestMethod.GET)
        public String editUserDetails(ModelMap model) {
            User user = userService.findBySSO(getPrincipal());
            model.addAttribute("user", user);
            model.addAttribute("edit", true);
            model.addAttribute("loggedinuser", getPrincipal());
            return "registration";
        }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String ssoId) {

        if (result.hasErrors()) {
            return "registration";
        }
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getName() + " "+ user.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    @RequestMapping(value = { "/edit-details-user-{ssoId}" }, method = RequestMethod.POST)
    public String updateUserDetails(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String ssoId) {

        if (result.hasErrors()) {
            return "registration";
        }
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getName() + " "+ user.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }


    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";
    }


    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<Role> initializeRoles() {
        return roleService.findAll();
    }

    @ModelAttribute("userrole")
    public List<Role> initializeUserRole() {
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findById(1L));
        return roles;
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/";
    }

    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }


}
