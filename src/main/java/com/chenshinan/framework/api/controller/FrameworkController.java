package com.chenshinan.framework.api.controller;

import com.chenshinan.framework.api.dto.PageInfo;
import com.chenshinan.framework.api.dto.ProjectDTO;
import com.chenshinan.framework.api.dto.ProjectSearchParam;
import com.chenshinan.framework.api.service.ProjectService;
import com.chenshinan.framework.domain.Project;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author shinan.chen
 * @date 2021/05/16
 */
@RestController
@RequestMapping(value = "framework")
@Api(value = "framework", tags = "代码框架")
public class FrameworkController {
    @Resource
    private ProjectService projectService;
    @Resource
    private ModelMapper modelMapper;

    @PostMapping(value = "/create")
    @ApiOperation(value = "创建模型", httpMethod = "POST")
    public ResponseEntity<Project> create(@RequestBody @Valid ProjectDTO create) {
        Project project = modelMapper.map(create, Project.class);
        return new ResponseEntity<>(projectService.baseCreate(project), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改模型", httpMethod = "POST")
    public ResponseEntity<Project> update(@RequestBody @Valid ProjectDTO update) {
        Project project = modelMapper.map(update, Project.class);
        return new ResponseEntity<>(projectService.baseUpdate(project), HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    @ApiOperation(value = "获取单个详情", httpMethod = "GET")
    public ResponseEntity<Project> selectById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(projectService.selectById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除模型", httpMethod = "POST")
    public ResponseEntity deleteById(@RequestParam("id") Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/page")
    @ApiOperation(value = "分页查询", httpMethod = "GET")
    public ResponseEntity<PageInfo<Project>> page(ProjectSearchParam param) {
        return new ResponseEntity<>(projectService.page(param.getKeyword(), param.getPageNum(), param.getPageSize()), HttpStatus.OK);
    }
}
