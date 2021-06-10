package behavioral.medium.design.dao;

import behavioral.medium.design.po.User;

public interface IUserDao {

    User queryUserInfoById(Long id);

}
