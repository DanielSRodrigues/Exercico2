package br.com.unibratec.exercico2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.edtName)
    EditText mEdtName;
    @Bind(R.id.chkSendMail)
    CheckBox mChkSendMail;
    @Bind(R.id.btnSocial)
    Button mBtnSocial;
    public static int idSocialNetwork = R.id.rbdFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            idSocialNetwork = savedInstanceState.getInt(SocialNetwork.idPuExtra);
        }
        setSocialNetworkText();
    }

    private void setSocialNetworkText() {
        mBtnSocial.setText(SocialNetwork.getSocialNetworkString(this, idSocialNetwork));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SocialNetwork.idPuExtra, idSocialNetwork);
    }

    @OnClick(R.id.btnSocial)
    public void getSocial(View view) {
        Intent intent = new Intent(this, TelaRedesSociais.class);
        intent.putExtra(SocialNetwork.idPuExtra, idSocialNetwork);
        startActivityForResult(intent, 0);
    }

    @OnClick(R.id.btnSend)
    public void sendResult(View view) {
        Intent intent = new Intent(this, TelaConsultaResultado.class);
        intent.putExtra(SocialNetwork.idPuExtra, idSocialNetwork);
        intent.putExtra("checked", mChkSendMail.isChecked());
        intent.putExtra("name", mEdtName.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            idSocialNetwork = data.getIntExtra(SocialNetwork.idPuExtra, 0);
            setSocialNetworkText();
        }
    }
}
