package com.isuwang.dapeng.core;

import com.isuwang.org.apache.thrift.TException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * soa方法处理器
 *
 * @author craneding
 * @date 15/9/18
 */
public abstract class SoaProcessFunction<I, REQ, RES, REQSerializer, RESSerializer> {

    private final String methodName;
    private REQSerializer reqSerializer;
    private RESSerializer resSerializer;

    protected SoaProcessFunction(String methodName, REQSerializer reqSerializer, RESSerializer resSerializer) {
        this.methodName = methodName;
        this.reqSerializer = reqSerializer;
        this.resSerializer = resSerializer;
    }

    public abstract REQ getEmptyArgsInstance();

    public abstract RES getResult(I iface, REQ args) throws TException;

    public Future<RES> getResultAsync(I iface, REQ args) throws TException {
        return new CompletableFuture<>();
    }

    protected abstract boolean isOneway();

    public String getMethodName() {
        return methodName;
    }

    public REQSerializer getReqSerializer() {
        return reqSerializer;
    }

    public void setReqSerializer(REQSerializer reqSerializer) {
        this.reqSerializer = reqSerializer;
    }

    public RESSerializer getResSerializer() {
        return resSerializer;
    }

    public void setResSerializer(RESSerializer resSerializer) {
        this.resSerializer = resSerializer;
    }
}
