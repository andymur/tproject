package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tapplication.exceptions.AlreadyExistException;
import tapplication.model.User;
import tapplication.service.UserServiceImpl;

/**
 * Created by alexpench on 23.03.17.
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(path = "register", method = RequestMethod.POST)
    public void register(@RequestBody User user) throws AlreadyExistException {
        userService.saveUser(user);
    }
}
