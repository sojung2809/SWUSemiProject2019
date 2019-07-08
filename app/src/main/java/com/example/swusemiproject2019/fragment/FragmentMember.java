package com.example.swusemiproject2019.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.swusemiproject2019.R;
import com.example.swusemiproject2019.activity.CameraCapture2Activity;
import com.example.swusemiproject2019.activity.LoginActivity;
import com.example.swusemiproject2019.bean.MemberBean;
import com.example.swusemiproject2019.db.FileDB;

import java.io.File;

public class FragmentMember extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member, container, false);

        ImageView imgProfile = view.findViewById(R.id.imgProfile);
        TextView txtMemId = view.findViewById(R.id.txtMemId);
        TextView txtMemName = view.findViewById(R.id.txtMemName);
        TextView txtMemPw = view.findViewById(R.id.txtMemPw);
        TextView txtMemDate = view.findViewById(R.id.txtMemDate);
        Button btnLogout = view.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(mBtnLogout);

        //파일DB 에서 가져온다.
        MemberBean memberBean = FileDB.getLoginMember( getActivity() );

        imgProfile.setImageURI( Uri.fromFile(new File(memberBean.photoPath)) );
        txtMemId.setText( memberBean.memId );
        txtMemName.setText( memberBean.memName );
        txtMemPw.setText( memberBean.memPw );
        txtMemDate.setText( memberBean.memRegDate );

        return view;
    }
    private View.OnClickListener mBtnLogout = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent ii = new Intent(getActivity(), LoginActivity.class);
            startActivity(ii);
        }
    };
}

