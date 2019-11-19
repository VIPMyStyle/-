package com.mryi.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mryi.ssm.SysLog;
import com.mryi.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
  @Autowired SysLogService sysLogService;

  @RequestMapping("/findAll.do")
  public ModelAndView findAll(
      @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
      @RequestParam(name = "size", required = true, defaultValue = "3") Integer size)
      throws Exception {
    ModelAndView mav = new ModelAndView();
    List<SysLog> sysLogs = sysLogService.findAll(page, size);
    PageInfo pageInfo = new PageInfo(sysLogs);
    mav.addObject("pageInfo", pageInfo);
    mav.setViewName("syslog-list");
    return mav;
  }

  @RequestMapping("/syslogDel.do")
  public String productDel(@RequestParam(name = "id", required = true) String[] ids)
      throws Exception {
    sysLogService.syslogDel(ids);
    return "redirect:findAll.do";
  }
}
