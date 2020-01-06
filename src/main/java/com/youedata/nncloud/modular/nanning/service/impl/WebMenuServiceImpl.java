package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.core.util.Convert;
import com.youedata.nncloud.modular.nanning.dao.WebMenuMapper;
import com.youedata.nncloud.modular.nanning.model.vo.WebMenuVo;
import com.youedata.nncloud.modular.nanning.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.youedata.nncloud.modular.nanning.model.WebMenu;
import org.springframework.stereotype.Service;
import com.youedata.nncloud.modular.nanning.service.IWebMenuService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 菜单管理Service
 *
 * @author Monkey
 * @Date 2018-11-19 17:50:10
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class WebMenuServiceImpl extends ServiceImpl<BaseMapper<WebMenu>,WebMenu> implements IWebMenuService {
    @Resource
    private WebMenuMapper webMenuMapper;
    @Autowired
    private IQuestionService iQuestionService;


    @Override
    public String getCode(Integer menuPid) {
        return webMenuMapper.getCode(menuPid);
    }

    /**
     * 新增菜单
     * @param webMenu
     * @param menuIcon
     */
    @Override
    public void insertNewMenu(WebMenu webMenu, MultipartFile menuIcon) throws Exception{

        MultipartFile[] files = {menuIcon};
        String[] path = iQuestionService.addFiles(files, 0);
        webMenu.setWebMenuIcon(path[0]);
        this.insert(webMenu);
    }

    /**
     * 更新菜单
     * @param webMenu
     * @param menuIcon
     * @throws Exception
     */
    @Override
    public void updateMenu(WebMenu webMenu, MultipartFile menuIcon) throws Exception {
        MultipartFile[] files = {menuIcon};
        String[] path = iQuestionService.addFiles(files, 0);
        webMenu.setWebMenuIcon(path[0]);
        this.updateById(webMenu);
    }

    /**
     * 根据id查找
     * @param menuId
     * @return
     */
    @Override
    public WebMenu getById(Integer menuId) {
        return webMenuMapper.getById(menuId);
    }

    /**
     * 删除菜单
     * @param menuId
     */
    @Override
    public void deleteMenu(Integer menuId, Integer menuPid) {
        webMenuMapper.deleteMenu(menuId, menuPid);
    }

    /**
     * 获取菜单树形
     * @return
     */
    @Override
    public List<WebMenuVo> menuTreeList() {
        //获取父节点
        List<WebMenuVo> webMenus = webMenuMapper.getPnode(null);
        if(webMenus != null && webMenus.size() != 0){
            //获取子节点
            for(WebMenuVo webMenuVo: webMenus){
                List<WebMenuVo> children = webMenuMapper.getNode(webMenuVo.getId(),null);
                webMenuVo.setChildren(children);
            }
        }else{
            return  webMenus;
        }
        return webMenus;
    }

    /**
     * 主页左侧菜单
     * @param userId
     * @return
     */
    @Override
    public List<WebMenuVo> homeMenuTreeList(Integer userId) {
        //根据用户id获取角色id获取菜单ids
        String menuIds = webMenuMapper.getMenuIdsByUserId(userId);
        List ids =  Arrays.asList(Convert.toIntArray(menuIds));
        if(ids == null ||ids.size() == 0){
            return null;
        }
        //获取父节点
        List<WebMenuVo> webMenus = webMenuMapper.getHomePnode(ids);
        if(webMenus != null && webMenus.size() != 0){
            //获取子节点
            for(WebMenuVo webMenuVo: webMenus){
                List<WebMenuVo> children = webMenuMapper.getHomeNode(webMenuVo.getId(),ids);
                webMenuVo.setChildren(children);
            }
        }else{
            return  webMenus;
        }
        return webMenus;
    }

    /**
     * 根据角色id获取菜单树形
     * @param roleId
     * @return
     */
    @Override
    public List<WebMenuVo> menuTreeListByRoleId(Integer roleId) {
        //根据角色id获取菜单ids
        String menuIds = webMenuMapper.getMenuIdsByRoleId(roleId);
        List ids =  Arrays.asList(Convert.toIntArray(menuIds));
        if(ids == null ||ids.size() == 0){
            return this.menuTreeList();
        }
        //获取父节点
        List<WebMenuVo> webMenus = webMenuMapper.getPnode(ids);
        if(webMenus != null && webMenus.size() != 0){
            //获取子节点
            for(WebMenuVo webMenuVo: webMenus){
                List<WebMenuVo> children = webMenuMapper.getNode(webMenuVo.getId(),ids);
                webMenuVo.setChildren(children);
            }
        }else{
            return  webMenus;
        }
        return webMenus;
    }
}
