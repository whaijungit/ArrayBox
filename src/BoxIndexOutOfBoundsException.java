/**
 * 自定义仓库里面没有你想要的元素
 */
public class BoxIndexOutOfBoundsException extends RuntimeException {
    public BoxIndexOutOfBoundsException(){}
    public BoxIndexOutOfBoundsException(String msg){
        super(msg);//给Arraybox
    }
}
