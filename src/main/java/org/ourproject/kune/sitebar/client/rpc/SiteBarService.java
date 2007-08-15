package org.ourproject.kune.sitebar.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializableException;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

// TODO: cambiar nombre a UserService
public interface SiteBarService extends RemoteService {

    void login(String nickOrEmail, String passwd) throws SerializableException;

    void logout() throws SerializableException;

    public class App {
	private static SiteBarServiceAsync ourInstance = null;

	public static synchronized SiteBarServiceAsync getInstance() {
	    if (ourInstance == null) {
		ourInstance = (SiteBarServiceAsync) GWT.create(SiteBarService.class);
		((ServiceDefTarget) ourInstance).setServiceEntryPoint(GWT.getModuleBaseURL() + "SiteBarService");
	    }
	    return ourInstance;
	}

	public static void setMock(final SiteBarServiceAsync mock) {
	    ourInstance = mock;
	}
    }
}
