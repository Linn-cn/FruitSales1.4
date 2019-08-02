package com.zl.controller;

import com.zl.pojo.UserDO;
import com.zl.service.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: FruitSales
 * @classname: RedisController
 * @description:
 * @author: 朱林
 * @create: 2019-06-26 13:51
 **/
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUserService redisUserService;


    @RequestMapping("/hashAdd")
    @ResponseBody
    public String hashAdd(){
        redisUserService.hashAdd();
        return "hashAdd";
    }

    @RequestMapping("/hashGet")
    @ResponseBody
    public UserDO hashGet(Integer id){
        UserDO userDO = redisUserService.hashGet(id);
        return userDO;
    }

    @RequestMapping("/listPush")
    @ResponseBody
    public String listPush(){
        redisUserService.listPush();
        return "listPush";
    }

    @RequestMapping("/listRange")
    @ResponseBody
    public List<String> listRange(Integer pageNum,Integer pageSize){
        List<String> list = redisUserService.listRange(pageNum,pageSize);
        return list;
    }

    @RequestMapping("/listQueueTest")
    @ResponseBody
    public String listQueueTest(String cardId){
        //1.用户进行支付完成后，生成对应的物流队列;
        redisUserService.listQueueInit(cardId);
        System.out.println("---当前待执行的任务队列");
        List<String> list1 = redisUserService.listQueueWait(cardId);
        for (String s : list1){
            System.out.println(s);
        }

        System.out.println("---物流小哥开始运输");
        redisUserService.listQueueTouch(cardId);

        System.out.println("---已完成的任务队列");
        List<String> list2 = redisUserService.listQueueSucc(cardId);
        for (String s : list2){
            System.out.println(s);
        }
        return "成功";
    }
}
