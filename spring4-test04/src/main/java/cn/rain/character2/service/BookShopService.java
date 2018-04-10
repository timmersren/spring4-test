package cn.rain.character2.service;

/**
 * description:
 *
 * @author 任伟
 * @date create on 2018-04-10 14:12
 **/
public interface BookShopService {
    /**
    * description: 用户买书
    * @param username 用户名
    * @param isbn 图书编号
    **/
    void purchase(String username, Integer isbn);
}
