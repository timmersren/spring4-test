package cn.rain.character3.service;

/**
 * description:
 * @author 任伟
 * @date create on 2018-04-10 14:12
 **/
public interface XMLBookShopService {
    /**
    * description: 用户买书
    * @param username 用户名
    * @param isbn 图书编号
    **/
    void purchase(String username, Integer isbn);
}
