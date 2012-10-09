package com.cloudmine.api;

import android.app.Activity;
import com.cloudmine.api.rest.CMSocial;
import com.cloudmine.api.rest.callbacks.Callback;
import com.cloudmine.api.rest.response.CMObjectResponse;
import com.singly.android.client.SinglyClient;

/**
 * Social that requires an activity to authorize, so that the user can log in through a GUI
 * <br>
 * Copyright CloudMine LLC. All rights reserved<br>
 * See LICENSE file included with SDK for details.
 */
public class CMAndroidSocial extends CMSocial {



    private final SinglyClient client = SinglyClient.getInstance();

    /**
     * Switch from the current Activity to the log in page for the given service. On completion, the current Activity
     * will be shown. The OAuth token will be passed into the given callback
     * @param service
     * @param activity
     * @param callback
     */
    public void authorize(final Service service, Activity activity, final Callback<CMObjectResponse> callback) {
        try {
            client.authenticate(activity, service.asUrlString(), callback);
        }catch(Exception e) {
            callback.onFailure(e, "");
        }
    }
}
