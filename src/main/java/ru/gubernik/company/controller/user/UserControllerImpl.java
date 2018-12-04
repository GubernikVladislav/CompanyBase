package ru.gubernik.company.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gubernik.company.service.user.UserService;
import ru.gubernik.company.view.ResultView;
import ru.gubernik.company.view.user.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<UserView> users(UserView view) {
        return userService.users(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/{id:[\\d]+}", method = {GET})
    public UserView get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResultView update(UserView view) {
        return userService.update(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResultView save(UserView view) {
        return userService.save(view);
    }
}
