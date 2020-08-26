package com.onePtwoL.acneanalyzer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2> {
    private ArrayList<Result> mList;
    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        public ImageView resultImage, seriousImage;
        public TextView resultTypeTextView, cureTextView, resalveView, salveView;
        public CheckBox checkBoxHome, checkBoxHospital, checkBoxInfection;

        public MyViewHolder2(View v) {
            super(v);
            resultImage = v.findViewById(R.id.result_skin_imageView);
            resultTypeTextView = v.findViewById(R.id.result_type_textView);
            cureTextView = v.findViewById(R.id.result_cure_textView);

            seriousImage = v.findViewById(R.id.result_serious_imageView);
            salveView = v.findViewById(R.id.result_salve_textView);

        }
    }

    public MyAdapter2(ArrayList<Result> myDataset) {
        mList = myDataset;
    }

    @Override
    public MyAdapter2.MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_row, parent, false);
        MyViewHolder2 vh = new MyViewHolder2(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, final int position) {
        // 이미지 뷰
        String imagepath = mList.get(position).getSkinPicturePath();

        File imageFile = new File(imagepath);
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        holder.resultImage.setImageBitmap(bitmap);

        // 결과 적용
        String typeNumber = mList.get(position).getAcneTypeNum();
        if(typeNumber.equals("1") == true){
            holder.resultTypeTextView.setText("화이트헤드");
            holder.cureTextView.setText(
                    "1. 스팀타월로 모공 열어주기\n2. 클랜징 오일 세안하기(식물성 오일 추천)\n3. 모공 수축팩 사용");
            holder.seriousImage.setImageResource(R.drawable.one);
            holder.salveView.setText("- 후시딘(스테로이드 성분 X)\n- 마데카솔\n  (센텔라 아시아티카, 식물 성분)\n- 클리어 틴 이부 더블 스팟 톡\n  (이부프로펜피코놀(JP))");
        }else if(typeNumber.equals("2") == true){
            holder.resultTypeTextView.setText("블랙헤드");
            holder.cureTextView.setText(
                    "1. 하루에 두 번만 세수하기 (아침, 잠들기 전)\n2. 여드름 원성(여드름을 유발하는 성분)이 아닌 제품 구매\n3. 운동후 깨끗이 씻기");
            holder.seriousImage.setImageResource(R.drawable.two);
            holder.salveView.setText("- 후시딘(스테로이드 성분 X)\n- 마데카솔\n  (센텔라 아시아티카, 식물 성분)\n- 클리어 틴 이부 더블 스팟 톡\n  (이부프로펜피코놀(JP))\n- 테라 크루즈(유황연고)");
        }else if(typeNumber.equals("3") == true){
            holder.resultTypeTextView.setText("구진");
            holder.cureTextView.setText("- 매일 두세 번 반드시 체온보다 뜨거운 물을 사용하여 피지를 녹이고, 향기나 자극이 없는 비누로 꼼꼼하게 세수하기\n- 유성 화장품의 사용을 삼가고 수축성 로션을 바르는 것이 좋음\n- 머리도 자주 감고 머리카락이 이마에 닿지 않게 하기");
            holder.seriousImage.setImageResource(R.drawable.three);
            holder.salveView.setText("- 병원 처방이 필요한 약입니다.");

        }else if(typeNumber.equals("4") == true){
            holder.resultTypeTextView.setText("농포");
            holder.cureTextView.setText("- 압출이 가능하지만 권장하지 않음\n  압출 후, 여드름 흉터가 될 확률이 매우 높음\n- 병원 치료를 권장");
            holder.seriousImage.setImageResource(R.drawable.four);
            holder.salveView.setText("- 병원 처방이 필요한 약입니다.");

        }else if(typeNumber.equals("5") == true){
            holder.resultTypeTextView.setText("결절, 낭종");
            holder.cureTextView.setText("- 압출 되지 않으며, 연고를 발라도 효과가 없음 \n- 병원에서 적절한 치료를 받아야 함");
            holder.seriousImage.setImageResource(R.drawable.five);
            holder.salveView.setText("- 병원 처방이 필요한 약입니다.");

        }else{
            holder.resultTypeTextView.setText("존재하지 않음");
            holder.cureTextView.setText("존재하지 않는 내용");
            holder.seriousImage.setImageResource(R.drawable.acne);
            holder.salveView.setText("존재하지 않는 내용");
        }

    }



    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}