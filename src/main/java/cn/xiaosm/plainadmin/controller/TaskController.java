/**
 * Copyright: 2019-2020，小树苗(www.xiaosm.cn)
 * FileName: TaskController
 * Author:   Young
 * Date:     2020/6/18 13:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Young         修改时间           版本号             描述
 */
package cn.xiaosm.plainadmin.controller;

import cn.xiaosm.plainadmin.annotation.LogRecord;
import cn.xiaosm.plainadmin.entity.Task;
import cn.xiaosm.plainadmin.entity.ResponseBody;
import cn.xiaosm.plainadmin.entity.enums.StatusEnum;
import cn.xiaosm.plainadmin.service.TaskService;
import cn.xiaosm.plainadmin.utils.ResponseUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Young
 * @create 2020/6/18
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    @PreAuthorize("hasAuthority('task:query') or hasRole('admin')")
    public ResponseBody queryTasks(Page<Task> page, Task task) {
        Page<Task> list = taskService.listOfPage(page, task);
        return ResponseUtils.buildSuccess("获取了任务列表", list);
    }

    @PutMapping
    @LogRecord("添加任务")
    @PreAuthorize("hasAuthority('task:add') or hasRole('admin')")
    public ResponseBody saveTask(@RequestBody Task task) {
        boolean b = taskService.addEntity(task);
        return b == true ? ResponseUtils.buildSuccess("新增任务信息成功")
                : ResponseUtils.buildFail("保存失败");
    }

    @PostMapping
    @LogRecord("修改任务")
    @PreAuthorize("hasAuthority('task:modify') or hasRole('admin')")
    public ResponseBody modifyTask(@RequestBody Task task) {
        boolean b = taskService.modifyEntity(task);
        return b == true ? ResponseUtils.buildSuccess("修改任务信息成功")
                : ResponseUtils.buildFail("修改失败");
    }

    @DeleteMapping
    @LogRecord("删除任务")
    @PreAuthorize("hasAuthority('task:delete') or hasRole('admin')")
    public ResponseBody deleteTasks(@RequestBody Set<Integer> ids) {
        int b = taskService.removeByIds(ids);
        return b > 0 ? ResponseUtils.buildSuccess("删除任务成功")
                : ResponseUtils.buildFail("删除任务失败");
    }
}