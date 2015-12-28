package id.web.faisalabdillah.web.ctrl;

import id.web.faisalabdillah.domain.Group;
import id.web.faisalabdillah.domain.Role;
import id.web.faisalabdillah.domain.User;
import id.web.faisalabdillah.domain.UserDetail;
import id.web.faisalabdillah.service.IGroupService;
import id.web.faisalabdillah.service.IRoleService;
import id.web.faisalabdillah.service.IUserService;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/insertGroup")
	public @ResponseBody Map<String, Object> insertGroup(){
		Map<String, Object> map=new HashMap<String, Object>();
		Group group=new Group();
		group.setCode("GUEST");
		group.setDescription("DESCRIPTION");
		Set<Role> roles=new HashSet<Role>();
		roles.add(roleService.findById("ROLE_GUEST"));
		group.setRoles(roles);
		
		if(groupService.insert(group)){
			map.put("success","true" );
			System.out.println("Group add Success");
		}else{
			System.out.println("Group add Fail");
		}
		
//		map.put("data", groupService.findById("GUEST"));
		return map;
	}
	@RequestMapping("/insertRole")
	public @ResponseBody Map<String, Object> insertRole(){
		Map<String, Object> map=new HashMap<String, Object>();
		Role role=new Role();
		role.setCode("ROLE_GUEST");
		role.setDescription("Some Description");
		map.put("success", roleService.insert(role));
		map.put("role", role);
		return map;
	}
	
	@RequestMapping("/insert")
	public @ResponseBody Map<String, Object> insertTest(){
		Map<String, Object> map=new HashMap<String, Object>();
		User user=new User();
		Set<Group> sets=new HashSet<Group>();
		Group gr=groupService.findById("GUEST");
		sets.add(gr);
		user.setId("faitz");
		user.setActive(true);
		user.setCreatetm(new Date());
		user.setCreateby("admin");
		user.setGroup(sets);
		user.setDetail(new UserDetail());
//		user.setDetail(new UserDetail());
		System.out.println("Creating User success");
		userService.insert(user);
		
		User u = userService.findByIdEager("faitz");
		System.out.println(u.getId());
		map.put("sucess", true);
		map.put("user", u);
		return map;
	}
	
	@RequestMapping("/get")
	public @ResponseBody Map<String, Object> getTest(){
		Map<String, Object> map=new HashMap<String, Object>();
		User outUser=userService.findById("faitz");
		map.put("user", outUser);
		return map;
	}
	
	
}
