package com.bigfm.com.BigFmDataManagement.response;

public interface IDMResponse<T>{

    T getData();
    Integer getCode();
    T getAppMessage();

    void setData(T data);
    void setCode(Integer code);
    void setAppMessage(T appMessage);

}
