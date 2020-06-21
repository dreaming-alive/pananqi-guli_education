package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wyc
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/eduservice/teacher")
@Api(tags = {"讲师管理"})
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;
    
    @GetMapping("findAll")
    @ApiOperation(value = "所有讲师列表")
    public R findAllTeacher(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }
    
    @DeleteMapping("{id}")
    @ApiOperation("根据ID删除讲师")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) 
                                     @PathVariable("id") String id){
        boolean flag = teacherService.removeById(id);
        return R.ok();
    }
    
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(@PathVariable("page") Long page,
                      @PathVariable("limit") Long limit,
                      TeacherQuery teacherQuery){
        Page<EduTeacher> pageParam = new Page<EduTeacher>(page, limit);
        
        teacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();

        long total = pageParam.getTotal();
        
        return R.ok().data("total", total).data("rowd", records);
    }
    
    @ApiOperation("新增讲师")
    @PostMapping
    public R save(@RequestBody EduTeacher eduTeacher){
        teacherService.save(eduTeacher);
        return R.ok();
    }
    
    @ApiOperation("根据id查询")
    @GetMapping("{id}")
    public R getById(@PathVariable(name = "id") String id){
        EduTeacher teacher = teacherService.getById(id);
        return R.ok().data("item", teacher);
    }
    
    @ApiOperation("根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(@PathVariable String id,
                        @RequestBody EduTeacher eduTeacher){
        eduTeacher.setId(id);
        teacherService.updateById(eduTeacher);
        return R.ok();
    }
}

