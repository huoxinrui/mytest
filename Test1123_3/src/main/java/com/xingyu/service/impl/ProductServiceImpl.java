package com.xingyu.service.impl;

import com.xingyu.dao.IProductDao;
import com.xingyu.domain.Product;
import com.xingyu.service.IProductService;
import com.xingyu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() {
        List<Product> products=productDao.findAll();
        for (Product product : products) {
            //将从数据库中拉取的date格式的信息转化为string，存储到product的departureTimeStr中以及productStatus转化
            if(product.getDepartureTime()!=null){
                Date date=product.getDepartureTime();
                String dateStr=Utils.date2String(date);
                product.setDepartureTimeStr(dateStr);
            }
            if(product.getProductStatus()!=null){
                //需要进行一个判空操作
                if(product.getProductStatus()==1){
                    product.setProductStatusStr("开启");
                }else{
                    product.setProductStatusStr("关闭");
                }
            }

        }
        return products;
    }

    @Override
    public void save(Product product) {

        productDao.save(product);
    }
}
