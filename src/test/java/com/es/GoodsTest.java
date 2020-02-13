package com.es;

import com.es.qo.GoodsQueryObject;
import com.es.qo.PageResult;
import com.es.repository.IGoodsRepository;
import com.es.vo.GoodsVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoodsTest extends ApplicationTest{

    @Autowired
    private IGoodsRepository goodsRepository;

    /**
     *测试添加文档
     */
    @Test
    public void inster() throws Exception {
        GoodsVo article = new GoodsVo();
        article.setId("3");
        article.setLast_version("3.1.0");
        article.setName("跳大神");
        article.setTitle("这是一篇文档2");
        article.setContent("这是一篇文档这是一篇文档这是一篇文档这是一篇文档2");
        goodsRepository.insertOrUpdate(article);
    }

    /**
     * 测试删除文档
     */
    @Test
    public void delete() throws Exception {
        goodsRepository.delete("3");
    }

    /**
     * 测试通过id获取文档
     */
    @Test
    public void get() throws Exception {
        GoodsVo goodsVo = goodsRepository.get("3");
        System.out.println(goodsVo);
    }


    /**
     *测试获取所有文档
     */
    @Test
    public void getAll() throws Exception {
        List<GoodsVo> list = goodsRepository.getAllByIndex();
        list.forEach(goodsVo -> {
            System.out.println(goodsVo);
        });
    }

    /**
     * 搜索
     */
    @Test
    public void search() throws Exception {
        GoodsQueryObject qo = new GoodsQueryObject();
        qo.setKeyword("3");
        PageResult pageResult = goodsRepository.search(qo);
        pageResult.getData().forEach(articleVo -> {
            System.out.println(articleVo);
        });
    }
}
