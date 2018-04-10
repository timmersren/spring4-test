package cn.rain.character2.dao;

/**
 * description:
 *
 * @author 任伟
 * @date create on 2018-04-10 13:21
 **/
public interface BookShopDao {

    /**
    * description: 根据书号获取书的单价
    * @param isbn 书的编号
    * @return 书的价格
    **/
    Integer findBookPriceByIsbn(Integer isbn);

    /**
    * description: 更新库存，使书号对应的库存-1
    * @param isbn 书的编号
    **/
    void updateBookStack(Integer isbn);

    /**
    * description: 更新用户的余额（更新后的余额=用户当前余额-price）
    * @param username 用户名； price 花费的金额
    * @return 
    **/
    void updateUserBalance(String username, Integer price);

}
