/**
 * Copyright: 2019-2020，小树苗(www.xiaosm.cn)
 * FileName: RoleService
 * Author:   Young
 * Date:     2020/6/18 15:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Young         修改时间           版本号             描述
 */
package cn.xiaosm.plainadmin.service;

import cn.xiaosm.plainadmin.entity.Role;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Young
 * @create 2020/6/18
 * @since 1.0.0
 */
public interface RoleService extends BaseService<Role> {

    List<Role> getByUserId(Integer userId);
}