package com.joyowo.mytest.service;//
//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

import com.joyowo.mytest.pojo.Cat;
import com.joyowo.mytest.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ireliac on 2017/11/5.
 */
@Service
@Transactional
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public void add(Cat cat) {
        catRepository.save(cat);
    }

    @Override
    public void delete(Cat cat) {
        catRepository.delete(cat);
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @Override
    public void saveToRedis (Integer id) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set("cat","!1111");
    }
    @Override
    @Cacheable("oneCat")
    public Cat getCatByCatId(Integer catId) {
        Cat cat = catRepository.findOne(catId);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return cat;
    }

}
