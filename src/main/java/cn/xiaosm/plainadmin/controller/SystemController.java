/**
 * Copyright: 2019-2020
 * FileName: SystemController
 * Author:   Young
 * Date:     2020/6/30 8:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Young         修改时间           版本号             描述
 */
package cn.xiaosm.plainadmin.controller;

import cn.xiaosm.plainadmin.annotation.LogRecord;
import cn.xiaosm.plainadmin.entity.ResponseBody;
import cn.xiaosm.plainadmin.utils.ResponseUtils;
import cn.xiaosm.plainadmin.utils.SystemUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Young
 * @create 2020/6/30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/system")
public class SystemController {

    @GetMapping
    @PreAuthorize("hasAuthority('systemInfo:query') or hasRole('admin')")
    public ResponseBody getSystemInfo() {

        return ResponseUtils.buildSuccess("", SystemUtils.init());
    }

}