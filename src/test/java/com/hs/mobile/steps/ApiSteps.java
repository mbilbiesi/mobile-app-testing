package com.hs.mobile.steps;

import com.hs.mobile.data.Language;
import com.hs.mobile.rest.endpoints.MenusEndpoint;
import com.hs.mobile.rest.model.response.MenuGroup;
import com.hs.mobile.rest.model.response.MenusResponse;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hs.mobile.data.Language.ARABIC;
import static com.hs.mobile.data.Language.ENGLISH;

public class ApiSteps {

    @Step("Fetch expected menu groups using Menus API")
    public Map<Language, List<String>> getExpectedMenuGroups() {
        MenusEndpoint menusEndpoint = new MenusEndpoint();
        Map<String, String> params = new HashMap<>();
        Map<Language, List<String>> menuGroupNames = new HashMap<>();
        List<String> menuGroupsEn = new ArrayList<>();
        List<String> menuGroupAr = new ArrayList<>();

        params.put("branch_id", "521");
        List<MenuGroup> menuGroups = menusEndpoint.getMenusResponse(params).as(MenusResponse.class).getMenuGroups();

        for (MenuGroup menuGroup : menuGroups) {
            menuGroupAr.add(menuGroup.getName());
            menuGroupsEn.add(menuGroup.getNameEn());
        }

        menuGroupNames.put(ARABIC, menuGroupAr);
        menuGroupNames.put(ENGLISH, menuGroupsEn);
        return menuGroupNames;
    }
}
