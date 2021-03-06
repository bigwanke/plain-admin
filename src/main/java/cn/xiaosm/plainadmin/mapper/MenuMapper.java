/**
 * Copyright: 2019-2020，小树苗(www.xiaosm.cn)
 * FileName: MenuMapper
 * Author:   Young
 * Date:     2020/6/14 14:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Young         修改时间           版本号             描述
 */
package cn.xiaosm.plainadmin.mapper;

import cn.xiaosm.plainadmin.entity.Menu;
import cn.xiaosm.plainadmin.mapper.provider.MenuProvider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Young
 * @create 2020/6/14
 * @since 1.0.0
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("SELECT * FROM meun WHERE parent_menu = 0")
    @Results(id = "menuMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "children", column = "id",
                    many = @Many(select = "cn.xiaosm.plainadmin.mapper.MenuMapper.findAllByParentId"))
    })
    List<Menu> findAll();

    /**
     * 根据父级 id 查询菜单
     * @param parentId 父级 id，0表示顶级菜单
     * @return
     */
    @Select("SELECT * FROM meun WHERE parent_menu = ${parentId}")
    List<Menu> selectAllByParentId(Integer parentId);

    /**
     * 通过角色 id 查询所有菜单
     * 以树形结构存储，影响数据库效率，弃用
     * @param roleId
     * @return
     */
    @SelectProvider(value = MenuProvider.class, method = "sqlSelectByRoleIdAndRootMenu")
    @Results(id = "menuMapByRoleId", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "children", column = "{roleId = r.id, parentId = id}",
                many = @Many(select = "cn.xiaosm.plainadmin.mapper.MenuMapper.selectAllByRoleIdAndParentId",
                        fetchType = FetchType.LAZY))
    })
    @Deprecated
    List<Menu> selectAllByRoleIdOfTree(String roleId);

    /**
     * 通过角色 id 查询所有菜单
     * 这里是直接查角色拥有的所有菜单，树结构的创建交给后端处理
     * @param roleId
     * @return
     */
    @SelectProvider(value = MenuProvider.class, method = "sqlSelectByRoleIds")
    List<Menu> selectAllByRoleIds(String roleId);

    /**
     * 通过角色 id 和父级菜单 id 查询所有菜单
     * @param roleId
     * @param parentId
     * @return
     */
    @SelectProvider(value = MenuProvider.class, method = "sqlSelectByRoleIdAndParentId")
    @ResultMap("menuMapByRoleId")
    List<Menu> selectAllByRoleIdAndParentId(String roleId, Integer parentId);

}