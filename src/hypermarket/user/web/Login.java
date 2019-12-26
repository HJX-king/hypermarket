//package hypermarket.user.web;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.beanutils.BeanUtils;
//
//import hypermarket.user.bean.Users;
//
//import hypermarket.user.service.UserService;
//import hypermarket.utils.ResponseMsg;
//@WebServlet("/user/login")
//public class Login extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private UserService userService=new UserService();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ResponseMsg msg=new ResponseMsg();
//		Users user=new Users();
//		try {
//			BeanUtils.populate(user, req.getParameterMap());
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(user.getUserName()==null||user.getUserName().equals("")) {
//			msg.setCode(-1);
//			msg.setMessage("对不起,用户名不能为空");
//			resp.getOutputStream().write(msg.toString().getBytes());
//			return;
//		}
//		if(user.getPassword()==null||user.getPassword().equals("")) {
//			msg.setCode(-1);
//			msg.setMessage("对不起,密码不能为空");
//			resp.getOutputStream().write(msg.toString().getBytes());
//			return;
//		}
//		Users u=userService.getUserByUserNameAndPassword(user);
//		if(u!=null) {
//			HttpSession hs=req.getSession();
//			hs.setAttribute("login", u);
//			
//			msg.setCode(1);
//			msg.setMessage("恭喜你,登录成功");
//			resp.getOutputStream().write(msg.toString().getBytes());
//		}else {
//			msg.setCode(-1);
//			msg.setMessage("对不起,用户名密码不正确");
//			resp.getOutputStream().write(msg.toString().getBytes());
//		}
//	
//	
//	}
//
//}
