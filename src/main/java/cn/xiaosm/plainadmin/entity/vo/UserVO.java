/**
 * Copyright: 2019-2020
 * FileName: UserVO
 * Author:   Young
 * Date:     2020/6/21 15:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Young         修改时间           版本号             描述
 */
package cn.xiaosm.plainadmin.entity.vo;

import cn.xiaosm.plainadmin.entity.User;
import cn.xiaosm.plainadmin.exception.SQLOperateException;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Set;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Young
 * @create 2020/6/21
 * @since 1.0.0
 */
@Data
public class UserVO extends User {

    @TableField(exist = false)
    private Boolean isReset;
    @TableField(exist = false)
    private String newPwd;
    @TableField(exist = false)
    private String confirmPwd;
    // 角色id
    @TableField(exist = false)
    private Set<Integer> roleIds;

    public Set<Integer> getRoleIds() {
        return roleIds;
    }

    public UserVO setRoleIds(Set<Integer> roleIds) {
        this.roleIds = roleIds;
        return this;
    }


}