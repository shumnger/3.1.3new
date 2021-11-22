package SpringBootCRUD.controller;

import SpringBootCRUD.model.Role;
import SpringBootCRUD.model.User;
import SpringBootCRUD.service.RoleService;
import SpringBootCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class DataInit {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private Set<Role> roles1;
    private Set<Role> roles2;
    @PostConstruct
    public void dataInit() {
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        HashSet<Role> roles1 = new HashSet<>();
        roles1.add(roleService.getRoleByName("ROLE_ADMIN"));
        roles1.add(roleService.getRoleByName("ROLE_USER"));
        User user1 = new User("admin","admin","admin@mail","1234", roles1);
        userService.addUser(user1);

        HashSet<Role> roles2 = new HashSet<>();
        roles2.add(roleService.getRoleByName("ROLE_USER"));
        User user2 = new User("alex","alex","alex@mail","alex", roles2);
        userService.addUser(user2);
    }
}
