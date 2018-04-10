package cn.rain.character2.exception;

/**
 * description:
 *
 * @author 任伟
 * @date create on 2018-04-10 14:01
 **/
public class BookStockException extends RuntimeException {

    public BookStockException() {
        this("该书库存不足!");
    }

    public BookStockException(String message) {
        super(message);
    }
}
