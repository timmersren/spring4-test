package cn.rain.character3.service.impl;

import cn.rain.character3.service.XMLBookShopService;
import cn.rain.character3.service.XMLCashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description: 演示xml方式配置事务
 * @author 任伟
 * @date create on 2018-04-10 14:53
 **/
public class XMLCashierServiceImpl implements XMLCashierService {

    private XMLBookShopService XMLBookShopService;

    public void setXMLBookShopService(cn.rain.character3.service.XMLBookShopService XMLBookShopService) {
        this.XMLBookShopService = XMLBookShopService;
    }

    @Override
    public void checkout(String username, List<Integer> isbns) {
        for (Integer isbn: isbns) {
            XMLBookShopService.purchase(username, isbn);
        }
    }
}
