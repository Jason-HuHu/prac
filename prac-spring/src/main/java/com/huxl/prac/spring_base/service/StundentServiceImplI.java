package com.huxl.prac.spring_base.service;

import com.huxl.prac.spring_base.dao.IStudentDAO;
import com.huxl.prac.spring_base.dao.IStudentDAO;
import org.springframework.stereotype.Service;

/**
 * @author huxl
 * @createDate 2018/1/17 10:08
 */
@Service
//@Scope("prototype") 默认单例模式，加上该注解后可以改成多例
public class StundentServiceImplI implements IStudentService {
//    @Autowired
    private IStudentDAO studentDAO;
    @Override
    public Integer getSudentCount() {
        return studentDAO.qrystudentCount();
    }

  /*  public IStudentDAO getStudentDAO() {
        return studentDAO;
    }*/

    public void setStudentDAO(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
