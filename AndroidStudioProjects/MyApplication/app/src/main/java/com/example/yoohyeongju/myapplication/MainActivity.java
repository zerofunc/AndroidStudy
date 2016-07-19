package com.example.yoohyeongju.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yoohyeongju.myapplication.R;

public class MainActivity extends Activity {

    private String[] mContents = {"사자", "여우", "곰", "호랑이", "타조"
            , "말", "돼지", "사슴", "콩나물", "살쾡이", "푸우", "티몬"};
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv_list);
        mListView.setAdapter(new CustomArrayAdapter(this, R.layout.row, mContents));
        mListView.setOnItemClickListener(mItemClickListener);
    }


    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long l_position) {
            // parent는 AdapterView의 속성의 모두 사용 할 수 있다.
            String tv = (String)parent.getAdapter().getItem(position);
            Toast.makeText(getApplicationContext(), tv, Toast.LENGTH_SHORT).show();

            // view는 클릭한 Row의 view를 Object로 반환해 준다.
            TextView tv_view = (TextView)view.findViewById(R.id.tv_row_title);
            //tv_view.setText("바꿈");

            // Position 은 클릭한 Row의 position 을 반환해 준다.
            //Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
            // l_Position 은 클릭한 Row의 long type의 position 을 반환해 준다.
            //Toast.makeText(getApplicationContext(), "l = " + l_position, Toast.LENGTH_SHORT).show();
        }
    };


    class CustomArrayAdapter extends ArrayAdapter<String> {

        private LayoutInflater inflater = null;
        private ViewHolder viewHolder = null;

        public CustomArrayAdapter(Context c, int textViewResourceId,
                                  String[] strings) {
            super(c, textViewResourceId, strings);
            this.inflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return super.getCount();
        }

        @Override
        public String getItem(int position) {
            return super.getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {

            View v = convertview;

            if(v == null){
                viewHolder = new ViewHolder();
                v = inflater.inflate(R.layout.row, null);
                viewHolder.tv_title = (TextView) v.findViewById(R.id.tv_row_title);

                v.setTag(viewHolder);

            }else {
                viewHolder = (ViewHolder)v.getTag();
            }

            viewHolder.tv_title.setText(getItem(position));

            return v;
        }
    }

    class ViewHolder {
        public TextView tv_title;
    }
}


