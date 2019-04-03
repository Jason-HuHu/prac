package com.huxl.prac.spring_base.dao;

/**
 * @author huxl
 * @createDate 2018/1/17 10:09
 */
//@Repository
public class SudentDAOImpl implements IStudentDAO {
    @Override
    public Integer qrystudentCount() {
        return 10;
    }
}
