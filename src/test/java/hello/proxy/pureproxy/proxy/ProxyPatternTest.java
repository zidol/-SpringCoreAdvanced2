package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatterClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();

        ProxyPatterClient client = new ProxyPatterClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatterClient client = new ProxyPatterClient(cacheProxy);
        client.execute();
        client.execute();// 메모리에서 바로 반환
        client.execute();// 메모리에서 바로 반환
    }
}
