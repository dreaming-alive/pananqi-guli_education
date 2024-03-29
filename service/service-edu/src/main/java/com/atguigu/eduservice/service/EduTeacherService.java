package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author wyc
 * @since 2020-06-21
 */
public interface EduTeacherService extends IService<EduTeacher> {
    
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

}
