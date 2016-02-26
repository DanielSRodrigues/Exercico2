package br.com.unibratec.exercico2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TelaRedesSociais extends AppCompatActivity {
    @Bind(R.id.rbdFacebook)
    RadioButton rbdFacebook;
    @Bind(R.id.rbdGPlus)
    RadioButton rbdGPlus;
    @Bind(R.id.rbdTwitter)
    RadioButton rbdTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_redes_sociais);
        ButterKnife.bind(this);
        Intent callerIntent = getIntent();
        if (callerIntent != null) {
            setSelectedRadio(callerIntent.getIntExtra(SocialNetwork.idPuExtra, 0));
        }
    }

    @OnClick(R.id.btnSend)
    public void getSocial(View view) {
        Intent intent = new Intent();
        intent.putExtra(SocialNetwork.idPuExtra, getSelectedRaddio());
        setResult(RESULT_OK, intent);
        finish();
    }

    private void setSelectedRadio(int selectedSocialNetWork) {
        switch (selectedSocialNetWork) {
            case R.id.rbdFacebook:
                rbdFacebook.setChecked(true);
                break;
            case R.id.rbdTwitter:
                rbdTwitter.setChecked(true);
                break;
            case R.id.rbdGPlus:
                rbdGPlus.setChecked(true);
                break;
        }
    }

    private int getSelectedRaddio() {
        int selectedSocialNetwork = 0;
        if (rbdFacebook.isChecked()) {
            selectedSocialNetwork = R.id.rbdFacebook;
        } else if (rbdTwitter.isChecked()) {
            selectedSocialNetwork = R.id.rbdTwitter;
        } else if (rbdGPlus.isChecked()) {
            selectedSocialNetwork = R.id.rbdGPlus;
        }
        return selectedSocialNetwork;
    }
}
