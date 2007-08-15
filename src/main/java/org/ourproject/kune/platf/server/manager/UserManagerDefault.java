package org.ourproject.kune.platf.server.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.ourproject.kune.platf.server.domain.User;

import com.google.gwt.user.client.rpc.SerializableException;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class UserManagerDefault extends DefaultManager<User, Long> implements UserManager {
    private User userFinder;
    private final GroupManager groupManager;

    @Inject
    public UserManagerDefault(final Provider<EntityManager> provider, final GroupManager groupManager,
	    final SocialNetworkManager socialNetworkManager) {
	super(provider, User.class);
	this.groupManager = groupManager;
    }

    public List<User> getAll() {
	return userFinder.getAll();
    }

    public User createUser(final User user) throws SerializableException {
	groupManager.createUserGroup(user);
	persist(user);
	return user;
    }

    public User getByShortName(final String shortName) {
	try {
	    return userFinder.getByShortName(shortName);
	} catch (NoResultException e) {
	    return null;
	}
    }

    public User login(final String nickOrEmail, final String passwd) {
	// TODO: integrate a existing Auth manager
	User user;
	try {
	    user = userFinder.getByShortName(nickOrEmail);
	} catch (NoResultException e) {
	    try {
		user = userFinder.getByEmail(nickOrEmail);
	    } catch (NoResultException e2) {
		return null;
	    }
	}
	if (user.getPassword().equals(passwd)) {
	    return user;
	} else {
	    return null;
	}
    }

    @Inject
    public void setUserFinder(final User userFinder) {
	this.userFinder = userFinder;
    }
}
