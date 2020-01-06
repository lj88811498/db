package com.youedata.nncloud.modular.nanning.dao;

import com.youedata.nncloud.modular.nanning.model.WebMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youedata.nncloud.modular.nanning.model.vo.WebMenuVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 营商web菜单表 Mapper 接口
 * </p>
 *
 * @author Monkey
 * @since 2018-11-19
 */
@Transactional
@Component
public interface WebMenuMapper extends BaseMapper<WebMenu> {


    /**
     * 获取父节点
     * @return
     */
    List<WebMenuVo> getPnode(@Param("menuIds") List menuIds);
    /**
     * 获取子节点
     * @return
     */
    List<WebMenuVo> getNode(@Param("menuPid") Integer menuPid,
                            @Param("menuIds") List menuIds);
    /**
     * 获取主页菜单父节点
     * @return
     */
    List<WebMenuVo> getHomePnode(@Param("menuIds") List menuIds);
    /**
     * 获取主页菜单子节点
     * @return
     */
    List<WebMenuVo> getHomeNode(@Param("menuPid") Integer menuPid,
                                @Param("menuIds") List menuIds);

    /**
     * 获取code
     * @param menuPid
     * @return
     */
    String getCode(@Param("menuPid") Integer menuPid);

    /**
     * 根据id查找
     * @param menuId
     * @return
     */
    WebMenu getById(@Param("menuId") Integer menuId);

    /**
     * 删除菜单
     * @param menuId
     */
    void deleteMenu(@Param("menuId") Integer menuId,
                    @Param("menuPid") Integer menuPid);

    /**
     * 获取菜单树形
     * @return
     */
    List<WebMenuVo> menuTreeList();

    /**
     * 主页左侧菜单
     * @param userId
     * @return
     */
    String getMenuIdsByUserId(@Param("userId") Integer userId);
    /**
     * 根据角色id获取menuids
     * @param roleId
     * @return
     */
    String getMenuIdsByRoleId(@Param("roleId") Integer roleId);


}
