package hypermarket.user.web;



import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import hypermarket.user.bean.Users;
import hypermarket.user.service.UserService;
import hypermarket.utils.ResponseMsg;

@Controller
@RequestMapping("/user/")
public class LoginController {
	private UserService userService =new UserService();
	//跳到登录页
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	//登录后跳到主页
	@ResponseBody
	@RequestMapping("login")
	public ResponseMsg login(Users user ,HttpSession hs) {
		ResponseMsg msg=new ResponseMsg();
		if(user.getUserName()==null||user.getUserName().equals("")) {
			msg.setCode(-1);
			msg.setMessage("对不起,用户名不能为空");
			return msg;
		}
		if(user.getPassword()==null||user.getPassword().equals("")) {
			msg.setCode(-1);
			msg.setMessage("对不起,密码不能为空");
			return msg;
		}
		Users u=userService.getUserByUserNameAndPassword(user);
		if(u!=null) {
			hs.setAttribute("login", u);
			msg.setCode(1);
			msg.setMessage("恭喜你,登录成功");
			return msg;
		}else {
			msg.setCode(-1);
			msg.setMessage("对不起,用户名密码不正确");
			return msg;
		}
	}

}
