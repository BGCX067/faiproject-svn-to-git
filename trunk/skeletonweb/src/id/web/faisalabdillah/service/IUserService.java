package id.web.faisalabdillah.service;

import id.web.faisalabdillah.domain.User;

public interface IUserService extends IBaseInterface<User>{

	User findByIdEager(Object id);

}
