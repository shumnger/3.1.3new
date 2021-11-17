package SpringBootCRUD.controller;

import SpringBootCRUD.model.Role;
import SpringBootCRUD.model.User;
import SpringBootCRUD.service.RoleService;
import SpringBootCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

        User user1 = new User();
        user1.setUsername("admin");
        user1.setLastName("admin");
        user1.seteMail("admin@mail");
        user1.setPassword("1234");
        user1.setRoles(Set.of(roleService.getRoleByName("ROLE_ADMIN"),
                roleService.getRoleByName("ROLE_USER")));
        userService.addUser(user1);

        User user2 =new User();
        user2.setUsername("alex");
        user2.setLastName("alex");
        user2.seteMail("alex@mail");
        user2.setPassword("alex");
        user2.setRoles(Set.of(roleService.getRoleByName("ROLE_USER")));
        userService.addUser(user2);
    }
}
