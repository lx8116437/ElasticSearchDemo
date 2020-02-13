package com.es.controller;

import com.es.qo.GoodsQueryObject;
import com.es.qo.PageResult;
import com.es.repository.IGoodsRepository;
import com.es.util.Response;
import com.es.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EsGoodsDemoController {
    @Autowired
    IGoodsRepository goodsRepository;

    @GetMapping("/getAllByIndex")
    @ResponseBody
    public Response getAllByIndex() throws Exception {
        List<GoodsVo> list = goodsRepository.getAllByIndex();
        Response r = new Response();
        r.setData(list);
        return r;
    }

    @PostMapping("/getById")
    @ResponseBody
    public Response getById(@RequestBody GoodsVo vo) throws Exception {
        if(vo == null || vo.getId() == null){
            return Response.failure("参数错误",null);
        }
        GoodsVo o = goodsRepository.get(vo.getId());
        Response r = new Response();
        r.setData(o);
        return r;
    }

    @PostMapping("/search")
    @ResponseBody
    public Response search(@RequestBody GoodsVo vo) throws Exception {
        if(vo == null || vo.getName() == null || "".equals(vo.getName())){
            return Response.failure("参数错误",null);
        }
        GoodsQueryObject qo = new GoodsQueryObject();
        qo.setKeyword(vo.getName());
        PageResult pageResult = goodsRepository.search(qo);
        Response r = new Response();
        r.setData(pageResult);
        return r;
    }

    @PostMapping("/save")
    @ResponseBody
    public Response save(@RequestBody GoodsVo vo) {
        try {
//            articleRepository.insertOrUpdate(vo, vo.getIndex(), vo.getType());
            goodsRepository.insertOrUpdate(vo);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure("新增失败", vo.getId());
        }
        return Response.success(null);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    public Response delete(@RequestBody GoodsVo vo) {
        if(vo == null || vo.getId() == null){
            return Response.failure("参数错误",null);
        }
        try {
            goodsRepository.delete(vo.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure("删除失败", vo.getId());
        }
        return Response.success(null);
    }

}
