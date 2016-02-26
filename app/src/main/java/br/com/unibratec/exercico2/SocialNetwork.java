package br.com.unibratec.exercico2;

import android.content.Context;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Daniel Rodrigues on 24/02/2016.
 */
public class SocialNetwork {
    public static String idPuExtra;

    public static String getSocialNetworkString(Context ctx, int id )
    {
        String result= "";
        switch (id)
        {
            case R.id.rbdFacebook:
                result = ctx.getString(R.string.Facebook);
                break;
            case R.id.rbdTwitter:
                result = ctx.getString(R.string.Twitter);
                break;
            case R.id.rbdGPlus:
                result = ctx.getString(R.string.GPlus);
                break;
        }
        return  result;
    }
}
