package com.cfox.photobookdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class MultiImageSelectOneActivity extends Activity {

    private Button mBtnOpenBook;
    private ImageView view1,view2,view3;
    private int REQUEST_CODE = 1;

    //图片地址数组
    private ArrayList<String> mResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_select);


        view1 = (ImageView) findViewById(R.id.iv_1);
        view2 = (ImageView) findViewById(R.id.iv_2);
        view3 = (ImageView) findViewById(R.id.iv_3);

        mBtnOpenBook = (Button) findViewById(R.id.btn_open_photo_book);

        mBtnOpenBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MultiImageSelector selector = MultiImageSelector.create();
                selector.count(3)
                        .showCamera(true)
                        .multi()
                        .origin(mResults)
                        .start(MultiImageSelectOneActivity.this, REQUEST_CODE);


//                // start multiple photos selector
//                Intent intent = new Intent(MainActivity.this, ImagesSelectorActivity.class);
//                // max number of images to be selected
//                intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 3);
//                // min size of image which will be shown; to filter tiny images (mainly icons)
//                intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
//                // show camera or not
//                intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
//                // pass current selected images as the initial value
//                intent.putStringArrayListExtra(SelectorSettings.SELECTOR_INITIAL_SELECTED_LIST, mResults);
//                // start the selector
//                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE){

            if(resultCode == RESULT_OK){

//                mResults = data.getStringArrayListExtra(SelectorSettings.SELECTOR_RESULTS);
                mResults = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);

                if (mResults.size() >= 1)
                    Glide.with(this).load(mResults.get(0)).centerCrop().into(view1);
                if (mResults.size() >= 2)
                    Glide.with(this).load(mResults.get(1)).centerCrop().into(view2);
                if (mResults.size() >= 3)
                    Glide.with(this).load(mResults.get(2)).centerCrop().into(view3);
            }
        }
    }
}
