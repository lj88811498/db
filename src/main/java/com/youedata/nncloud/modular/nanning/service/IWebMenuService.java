package com.youedata.nncloud.modular.nanning.service;
import com.baomidou.mybatisplus.service.IService;
import com.youedata.nncloud.modular.nanning.model.WebMenu;
import com.youedata.nncloud.modular.nanning.model.vo.WebMenuVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理Service
 *
 * @author Monkey
 * @Date 2018-11-19 17:50:10
 */
public interface IWebMenuService extends IService<WebMenu>{


    /**
     * 获取code
     * @param menuPid
     * @return
     */
    String getCode(Integer menuPid);

    /**
     * 新增菜单
     * @param webMenu
     * @param menuIcon
     */
    void insertNewMenu(WebMenu webMenu, MultipartFile menuIcon) throws Exception;
    /**
     * 更新菜单
     * @param webMenu
     * @param menuIcon
     */
    void updateMenu(WebMenu webMenu, MultipartFile menuIcon) throws Exception;

    /**
     * 根据Id查找
     * @param menuId
     * @return
     */
    WebMenu getById(Integer menuId);

    /**
     * 删除菜单
     * @param menuId
     */
    void deleteMenu(Integer menuId, Integer menuPid);

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
    List<WebMenuVo> homeMenuTreeList(Integer userId);

    /**
     * 根据菜单ids获取菜单树形
     * @return
     */
    List<WebMenuVo> menuTreeListByRoleId(Integer roleId);
}
