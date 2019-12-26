package hypermarket.user.Dao;

import hypermarket.user.bean.Users;

public interface UserMapper {
	Users getUserByUserNameAndPassword(Users user);

}
