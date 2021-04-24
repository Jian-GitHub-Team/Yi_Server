package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qi
 * 测试连接
 */
@RestController
@RequestMapping("Yi/Contention")
public class Contention_Controller {
    @RequestMapping("getContention")
    public boolean getContention(){
        return true;
    }
}
