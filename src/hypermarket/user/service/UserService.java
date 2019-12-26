package hypermarket.user.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Scanner;

import hypermarket.user.Dao.UserMapper;
import hypermarket.user.bean.Users;
import hypermarket.utils.SqlUtils2;

public class UserService {
	
	
	
	public Users getUserByUserNameAndPassword(Users user) {
		MessageDigest digest;
		try {
			//获得一个MD5的转换器
			digest=MessageDigest.getInstance("md5");
			//把密码转换成字节数组,利用转换器的digest()方法加密,得到的也是一个字节数组
			byte[] bs=digest.digest(user.getPassword().getBytes());
			//将任意二进制转成字符串
			Encoder base64=Base64.getEncoder();
			String ps=base64.encodeToString(bs);
			user.setPassword(ps);
			UserMapper userMapper= SqlUtils2.getMapper(UserMapper.class);
			Users u=userMapper.getUserByUserNameAndPassword(user);
			SqlUtils2.release();
			return u;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		//加密完成之后, 二进制已经不是原来的能在码表中找到对应字符的数值了
				MessageDigest digest;
				try {
					digest = MessageDigest.getInstance("md5");
					Scanner sc = new Scanner(System.in);
					String str = sc.nextLine();
					byte[] bs = digest.digest(str.getBytes());
					
					Encoder base64 = Base64.getEncoder(); //将任意二进制转成字符串
					String ps = base64.encodeToString(bs);
					System.out.println(ps);
					sc.close();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//不可逆加密
	}

}
