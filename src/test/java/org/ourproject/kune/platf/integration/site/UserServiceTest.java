package org.ourproject.kune.platf.integration.site;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.ourproject.kune.platf.client.dto.LicenseDTO;
import org.ourproject.kune.platf.client.dto.LinkDTO;
import org.ourproject.kune.platf.client.dto.UserInfoDTO;
import org.ourproject.kune.platf.client.errors.EmailAddressInUseException;
import org.ourproject.kune.platf.client.errors.GroupNameInUseException;
import org.ourproject.kune.platf.client.errors.UserMustBeLoggedException;
import org.ourproject.kune.platf.integration.IntegrationTest;
import org.ourproject.kune.platf.integration.IntegrationTestHelper;
import org.ourproject.kune.platf.server.UserSession;
import org.ourproject.kune.platf.server.manager.I18nLanguageManager;
import org.ourproject.kune.platf.server.mapper.Mapper;
import org.ourproject.kune.platf.server.properties.DatabaseProperties;
import org.ourproject.kune.platf.server.users.Link;
import org.ourproject.kune.platf.server.users.UserInfo;
import org.ourproject.kune.platf.server.users.UserInfoService;
import org.ourproject.kune.sitebar.client.rpc.UserService;

import com.google.gwt.user.client.rpc.SerializableException;
import com.google.inject.Inject;

public class UserServiceTest extends IntegrationTest {
    @Inject
    UserSession session;
    @Inject
    DatabaseProperties properties;
    @Inject
    UserService userService;
    @Inject
    UserInfoService userInfoService;
    @Inject
    Mapper mapper;
    @Inject
    I18nLanguageManager i18nLangManager;

    @Before
    public void init() {
        new IntegrationTestHelper(this);
    }

    @Test
    public void testSiteNameLogin() throws SerializableException {
        assertNull(session.getUser().getId());
        userService.login(properties.getAdminShortName(), properties.getAdminPassword());
        assertNotNull(session.getUser().getId());
    }

    @Test
    public void testSiteEmailLogin() throws SerializableException {
        assertNull(session.getUser().getId());
        userService.login(properties.getAdminEmail(), properties.getAdminPassword());
        assertNotNull(session.getUser().getId());
    }

    @Test(expected = GroupNameInUseException.class)
    public void createUserExistingNameFails() throws SerializableException {
        assertNull(session.getUser().getId());
        userService.createUser(properties.getAdminShortName(), "test", "example@example.com", "123456",
                new LicenseDTO(), "en", "GB", "GMT");
    }

    @Test(expected = EmailAddressInUseException.class)
    public void createUserExistingEmailFails() throws SerializableException {
        assertNull(session.getUser().getId());
        userService.createUser("test", "test", properties.getAdminEmail(), "123456", new LicenseDTO(), "en", "GB",
                "GMT");
    }

    @Test(expected = UserMustBeLoggedException.class)
    public void testReloadUserInfoNotLogged() throws SerializableException {
        assertNull(session.getUser().getId());
        userService.reloadUserInfo("FOO");
    }

    @Test
    public void testUserInfo() throws SerializableException {
        doLogin();
        final UserInfo userInfo = userInfoService.buildInfo(session.getUser(), session.getHash());

        final UserInfoDTO userInfoDTO = mapper.map(userInfo, UserInfoDTO.class);
        assertEquals(userInfo.getName(), userInfoDTO.getName());
        assertEquals(userInfo.getChatName(), userInfoDTO.getChatName());
        assertEquals(userInfo.getChatPassword(), userInfoDTO.getChatPassword());
        final List<Link> adminsGroup = userInfo.getGroupsIsAdmin();
        final List<Link> adminsGroupDTO = userInfoDTO.getGroupsIsAdmin();
        assertEqualListsLink(adminsGroupDTO, adminsGroup);
    }

    private void assertEqualListsLink(final List<Link> listDTO, final List<Link> list) {
        assertEquals(listDTO.size(), list.size());
        for (int i = 0; i < listDTO.size(); i++) {
            final Object object = listDTO.get(i);
            assertEquals(LinkDTO.class, object.getClass());
            final LinkDTO d = (LinkDTO) object;
            final Link l = list.get(i);
            assertNotNull(d);
            assertNotNull(l);
            final LinkDTO map = mapper.map(l, LinkDTO.class);
            assertEquals(map.getShortName(), d.getShortName());
            assertEquals(map.getLink(), d.getLink());
        }
    }

}