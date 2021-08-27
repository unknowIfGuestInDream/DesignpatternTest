package util;

/**
 * @author: TangLiang
 * @date: 2021/8/27 9:06
 * @since: 1.0
 */
public interface O {

    interface $<A> {
        <B> void $();
    }

    void o($<O> o);

    default O o() {
        return $<O>::<O>$;
    }
}
