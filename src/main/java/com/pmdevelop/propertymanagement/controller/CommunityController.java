package com.pmdevelop.propertymanagement.controller;

import com.pmdevelop.propertymanagement.entity.Community;
import com.pmdevelop.propertymanagement.response.ApiResponse;
import com.pmdevelop.propertymanagement.service.CommunityService;
import com.pmdevelop.propertymanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@ResponseBody  // 表示返回的是 JSON 格式
@RequestMapping("/community")  // 统一使用 "/community" 路径前缀
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private RoomService roomService;

    // 显示所有小区
    @GetMapping("/list")
    public ApiResponse<Object> listCommunities() {
        List<Community> allCommunities = communityService.getAllCommunities();
        if (allCommunities != null && !allCommunities.isEmpty()) {
            return ApiResponse.success(allCommunities);
        } else {
            return ApiResponse.error(404, "抱歉，未找到小区");
        }
    }

    // 显示单个小区详细信息，返回 JSON 格式
    @GetMapping("/")
    public ApiResponse<Object> viewCommunity(@RequestParam(value = "id", required = true) Integer id) {
        Community community = communityService.getCommunityById(id);// 直接返回对象，Spring 会自动转换为 JSON 格式
        if (community != null) {
            return ApiResponse.success(community);
        } else {
            return ApiResponse.error(404, "未查询到相关的小区数据");
        }
    }

    // 根据小区的Id，查询该小区的楼号
    @GetMapping("/building")
    public ApiResponse<Object> getBuilding(@RequestParam(value = "communityId", required = true) Integer communityId) {
        List<Map<String,Integer>> result = roomService.getBuildingByCommunityId(communityId);
        if (result != null && !result.isEmpty()) {
            return ApiResponse.success(result);
        } else {
            return ApiResponse.error(404, "该小区下未获取到单元楼号");
        }
    }

    //根据小区的Id和楼号，查询该楼中的单元
    @GetMapping("/unit")
    public ApiResponse<Object> getUnitByCommunityAndBuilding(@RequestParam(value = "communityId", required = true) Integer communityId,
                                                              @RequestParam(value = "building", required = true) Integer building) {
        List<Map<String,Integer>> result = roomService.getUnitByCommunityAndBuilding(communityId, building);
        if (result != null && !result.isEmpty()) {
            return ApiResponse.success(result);
        } else {
            return ApiResponse.error(404, "该楼下未找到单元号");
        }
    }

    //根据小区Id楼号以及单元号获取全由房间信息
    @GetMapping("/room")
    public ApiResponse<Object> getRoomsInfo(@RequestParam("communityId") Integer communityId,
                                            @RequestParam("building") Integer building,
                                            @RequestParam("unit") Integer unit) {
        List<Map<String,String>> result = roomService.getRoomsInfo(communityId, building, unit);
        if (result != null && !result.isEmpty()) {
            return ApiResponse.success(result);
        } else {
            return ApiResponse.error(404, "未找到房间号");
        }
    }

    // 显示创建小区的表单
//    @GetMapping("/create")
//    public String createCommunityForm(Model model) {
//        model.addAttribute("community", new Community());
//        return "community/create";  // 返回创建小区的表单视图
//    }

    // 处理小区创建请求
//    @PostMapping("/create")
//    public String createCommunity(@ModelAttribute Community community) {
//        communityService.saveCommunity(community);
//        return "redirect:/community/list";  // 创建成功后重定向到小区列表页面
//    }

    // 显示更新小区的表单
//    @GetMapping("/update/{id}")
//    public String updateCommunityForm(@PathVariable("id") Integer id, Model model) {
//        Community community = communityService.getCommunityById(id);
//        if (community != null) {
//            model.addAttribute("community", community);
//            return "community/update";  // 返回更新小区的表单视图
//        } else {
//            model.addAttribute("error", "小区未找到");
//            return "error";  // 如果没有找到小区，返回错误页面
//        }
//    }

    // 处理小区更新请求
//    @PostMapping("/update")
//    public String updateCommunity(@ModelAttribute Community community) {
//        communityService.saveCommunity(community);  // 使用相同的保存方法处理更新
//        return "redirect:/community/list";  // 更新成功后重定向到小区列表页面
//    }

    // 处理删除小区请求
//    @GetMapping("/delete/{id}")
//    public String deleteCommunity(@PathVariable("id") Integer id) {
//        communityService.deleteCommunity(id);
//        return "redirect:/community/list";  // 删除成功后重定向到小区列表页面
//    }
}
