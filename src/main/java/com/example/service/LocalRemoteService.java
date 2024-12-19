package com.example.service;


public interface LocalRemoteService {

    void localRemote();

    String remoteRetryWithLocalRemote(String requestId);

    boolean localRetryWithPropagationRequired(String params);

    boolean localRetryWithPropagationRequiredNew(String params);

    boolean localRetryWithTryCatch1(String params);

    boolean localRetryWithTryCatch2(String params);

    boolean localRetryWithTwoRetryMethod(String params);
}
