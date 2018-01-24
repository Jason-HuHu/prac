package com.huxl.spring_base.dao;

import org.springframework.stereotype.Repository;

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
