package org.ourproject.kune.sitebar.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SiteBarServiceAsync {

    void login(String nickOrEmail, String passwd, AsyncCallback callback);

    void logout(AsyncCallback callback);

}
